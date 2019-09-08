package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import com.cloudera.stockcalculator.persistence.model.StockPrice;
import com.cloudera.stockcalculator.persistence.model.VestingEvent;
import com.cloudera.stockcalculator.persistence.repository.CurrencyRateRepository;
import com.cloudera.stockcalculator.persistence.repository.StockPriceRepository;
import com.cloudera.stockcalculator.persistence.repository.VestingEventRepository;
import com.cloudera.stockcalculator.service.json.TimeSeries;
import hu.mnb.webservices.MNBArfolyamServiceSoapGetExchangeRatesStringFaultFaultMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import java.net.MalformedURLException;
import java.text.*;
import java.util.Date;

@Service
public class RSUService {

    private static final String ALPHA_API_KEY = "GLZ1EP7H6DFY2HQU";

    @Inject
    private CurrencyRateRepository currencyRateRepository;

    @Inject
    private StockPriceRepository stockPriceRepository;

    @Inject
    private VestingEventRepository vestingEventRepository;

    @Inject
    private StockPriceProvider stockPriceProvider;

    @Inject CurrencyRateProvider currencyRateProvider;

    public void addNewVesting(Date date, Integer quantity) throws ParseException, MNBArfolyamServiceSoapGetExchangeRatesStringFaultFaultMessage, MalformedURLException {
        StockPrice stockPrice = stockPriceProvider.getStockPrice(date, StockType.CLOUDERA);
        stockPriceRepository.save(stockPrice);

        currencyRateProvider.getCurrencyRate(StockType.CLOUDERA.getCurrency());
        // TODO MNB API call
        CurrencyRate currencyRate = new CurrencyRate();
        currencyRate.setRate(null);
        currencyRate.setSource(StockType.CLOUDERA.getCurrency());
        currencyRate.setTarget(Currency.HUF);
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
