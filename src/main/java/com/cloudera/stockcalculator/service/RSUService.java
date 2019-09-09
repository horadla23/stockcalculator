package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.dto.taxation.VestingTaxInformation;
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

    @Inject
    private List<TaxInformationProvider> taxInformationProviderList;

    private final Map<Currency, CurrencyRateProvider> currencyCurrencyRateProviderMap = new HashMap<>();

    private final Map<TaxationType, TaxInformationProvider> taxInformationProviderMap = new HashMap<>();

    @PostConstruct
    public void populateRateProviderMap() {
        currencyRateProviderList.forEach(rateProvider ->
                currencyCurrencyRateProviderMap.put(rateProvider.getTargetCurrency(), rateProvider));
        taxInformationProviderList.forEach(taxInformationProvider ->
                taxInformationProviderMap.put(taxInformationProvider.getTaxationType(), taxInformationProvider));
    }

    public void addNewVesting(Date date, Integer quantity) {
        StockPrice stockPrice = stockPriceProvider.getStockPrice(date, StockType.CLOUDERA);

        VestingEvent vestingEvent = new VestingEvent();
        vestingEvent.setStockPrice(stockPrice);
        vestingEvent.setQuantity(quantity);
        vestingEvent.setVestingDate(date);
        vestingEventRepository.save(vestingEvent);
    }

    public VestingTaxInformation getTaxationInformationAboutVesting(VestingEventDto vestingEventDto, TaxationType taxationType) {
        CurrencyRate currencyRate = currencyCurrencyRateProviderMap.get(taxationType.getCurrency())
                .getCurrencyRate(StockType.CLOUDERA.getCurrency(), vestingEventDto.getVestingDate());
        return taxInformationProviderMap.get(taxationType).getTaxationInformationAboutVesting(vestingEventDto, currencyRate);
    }

    public VestingEvent getVestingEvent(Long id) {
        return vestingEventRepository.findById(id).get();
    }
}
