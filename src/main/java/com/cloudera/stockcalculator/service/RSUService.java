package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import com.cloudera.stockcalculator.persistence.model.StockPrice;
import com.cloudera.stockcalculator.persistence.model.VestingEvent;
import com.cloudera.stockcalculator.persistence.repository.CurrencyRateRepository;
import com.cloudera.stockcalculator.persistence.repository.StockPriceRepository;
import com.cloudera.stockcalculator.persistence.repository.VestingEventRepository;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.inject.Inject;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
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

    @Inject
    private CurrencyRateProvider currencyRateProvider;

    public void addNewVesting(Date date, Integer quantity) throws IOException, SAXException, ParserConfigurationException, ParseException {
        StockPrice stockPrice = stockPriceProvider.getStockPrice(date, StockType.CLOUDERA);
        stockPriceRepository.save(stockPrice);

        CurrencyRate currencyRate = currencyRateProvider.getCurrencyRate(StockType.CLOUDERA.getCurrency(), date);
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
