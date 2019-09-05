package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.model.Currency;
import com.cloudera.stockcalculator.model.CurrencyRate;
import com.cloudera.stockcalculator.model.StockPrice;
import com.cloudera.stockcalculator.model.VestingEvent;
import com.cloudera.stockcalculator.repository.CurrencyRateRepository;
import com.cloudera.stockcalculator.repository.StockPriceRepository;
import com.cloudera.stockcalculator.repository.VestingEventRepository;
import com.cloudera.stockcalculator.service.json.TimeSeries;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RSUService {

    private static final String ALPHA_API_KEY = "GLZ1EP7H6DFY2HQU";

    private static final String STOCK_SYMBOL = "CLDR";

    @Inject
    private CurrencyRateRepository currencyRateRepository;

    @Inject
    private StockPriceRepository stockPriceRepository;

    @Inject
    private VestingEventRepository vestingEventRepository;

    public void addNewVesting(Date date, Integer quantity, Long usdToHufRate) {
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        String dateAsString = df.format(date);

        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=CLDR&apikey=GLZ1EP7H6DFY2HQU";
        TimeSeries object = restTemplate.getForObject(resourceUrl, TimeSeries.class);

        StockPrice stockPrice = new StockPrice();
        stockPrice.setDate(date);
        stockPrice.setStockCurrency(Currency.USD);
        stockPrice.setStockPrice(Long.valueOf(object.getTimeSeriesByDate().get(dateAsString).getValues().get("4. close")));
        stockPriceRepository.save(stockPrice);

        // TODO MNB API call
        CurrencyRate currencyRate = new CurrencyRate();
        currencyRate.setRate(usdToHufRate);
        currencyRateRepository.save(currencyRate);

        VestingEvent vestingEvent = new VestingEvent();
        vestingEvent.setCurrencyRate(currencyRate);
        vestingEvent.setStockPrice(stockPrice);
        vestingEvent.setQuantity(quantity);
        vestingEvent.setVestingDate(date);
        vestingEventRepository.save(vestingEvent);
    }
}
