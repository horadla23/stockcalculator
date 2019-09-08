package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import com.cloudera.stockcalculator.persistence.model.StockPrice;
import com.cloudera.stockcalculator.persistence.model.VestingEvent;
import com.cloudera.stockcalculator.persistence.repository.VestingEventRepository;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RSUService {

    private static final String ALPHA_API_KEY = "GLZ1EP7H6DFY2HQU";

    @Inject
    private VestingEventRepository vestingEventRepository;

    @Inject
    private StockPriceProvider stockPriceProvider;

    @Inject
    private List<CurrencyRateProvider> currencyRateProviderList;

    private final Map<Currency, CurrencyRateProvider> currencyCurrencyRateProviderMap = new HashMap<>();

    @PostConstruct
    public void populateRateProviderMap() {
        currencyRateProviderList.forEach(rateProvider ->
                currencyCurrencyRateProviderMap.put(rateProvider.getTargetCurrency(), rateProvider));
    }

    public void addNewVesting(Date date, Integer quantity) {
        StockPrice stockPrice = stockPriceProvider.getStockPrice(date, StockType.CLOUDERA);

        CurrencyRate currencyRate = currencyCurrencyRateProviderMap.get(Currency.HUF)
                .getCurrencyRate(StockType.CLOUDERA.getCurrency(), date);

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
