package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.persistence.model.Currency;
import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import com.cloudera.stockcalculator.persistence.model.StockPrice;
import com.cloudera.stockcalculator.persistence.model.VestingEvent;
import com.cloudera.stockcalculator.persistence.repository.CurrencyRateRepository;
import com.cloudera.stockcalculator.persistence.repository.StockPriceRepository;
import com.cloudera.stockcalculator.persistence.repository.VestingEventRepository;
import com.cloudera.stockcalculator.service.json.TimeSeries;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import java.text.*;
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

    public void addNewVesting(Date date, Integer quantity, Float usdToHufRate) throws ParseException {
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        String dateAsString = df.format(date);

        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=CLDR&apikey=GLZ1EP7H6DFY2HQU";
        TimeSeries object = restTemplate.getForObject(resourceUrl, TimeSeries.class);

        StockPrice stockPrice = new StockPrice();
        stockPrice.setDate(date);
        stockPrice.setStockCurrency(Currency.USD);
        if (object.getTimeSeriesByDate().containsKey(dateAsString) &&
                object.getTimeSeriesByDate().get(dateAsString).containsKey("4. close")) {
            stockPrice.setStockPrice(Float.parseFloat(object.getTimeSeriesByDate().get(dateAsString).get("4. close")));
        } else {
            throw new BadRequestException("Date is not valid, no stock data have found or stock is not closed for that date.");
        }
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

    public VestingEvent getVestingEvent(Long id) {
        return vestingEventRepository.findById(id).get();
    }
}
