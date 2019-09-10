package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.api.dto.SellingEventDto;
import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.dto.taxation.SellingTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.VestingTaxInformation;
import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import com.cloudera.stockcalculator.persistence.model.SellingEvent;
import com.cloudera.stockcalculator.persistence.model.StockPrice;
import com.cloudera.stockcalculator.persistence.model.VestingEvent;
import com.cloudera.stockcalculator.persistence.repository.SellingEventRepository;
import com.cloudera.stockcalculator.persistence.repository.VestingEventRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
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
    private SellingEventRepository sellingEventRepository;

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

    public VestingEvent addNewVesting(Date date, Integer quantity) {
        StockPrice stockPrice = stockPriceProvider.getStockPrice(date, StockType.CLOUDERA);

        VestingEvent vestingEvent = new VestingEvent();
        vestingEvent.setStockPrice(stockPrice);
        vestingEvent.setQuantity(quantity);
        vestingEvent.setVestingDate(date);
        return vestingEventRepository.save(vestingEvent);
    }

    public SellingEvent addNewSelling(Date date, Integer quantity, Float additionalFee, Long vestingId) {
        StockPrice stockPrice = stockPriceProvider.getStockPrice(date, StockType.CLOUDERA);
        VestingEvent vestingEvent = getVestingEvent(vestingId);

        SellingEvent sellingEvent = new SellingEvent();
        sellingEvent.setVestingEvent(vestingEvent);
        sellingEvent.setSettlementDate(date);
        sellingEvent.setSettlementPrice(stockPrice);
        sellingEvent.setAdditionalFee(additionalFee);
        sellingEvent.setSoldQuantity(quantity);
        return sellingEventRepository.save(sellingEvent);
    }

    public VestingTaxInformation getTaxationInformationAboutVesting(VestingEventDto vestingEventDto, TaxationType taxationType) {
        CurrencyRate currencyRate = currencyCurrencyRateProviderMap.get(taxationType.getCurrency())
                .getCurrencyRate(StockType.CLOUDERA.getCurrency(), vestingEventDto.getStockPrice().getDate());
        return taxInformationProviderMap.get(taxationType).getTaxationInformationAboutVesting(vestingEventDto, currencyRate);
    }

    public SellingTaxInformation getTaxationInformationAboutSelling(VestingEventDto vestingEventDto, SellingEventDto sellingEventDto, TaxationType taxationType) {
        CurrencyRate currencyRate = currencyCurrencyRateProviderMap.get(taxationType.getCurrency())
                .getCurrencyRate(StockType.CLOUDERA.getCurrency(), sellingEventDto.getSettlementPrice().getDate());
        return taxInformationProviderMap.get(taxationType)
                .getTaxationInformationAboutStockSell(vestingEventDto, sellingEventDto, currencyRate);
    }

    public VestingEvent getVestingEvent(Long id) {
        return vestingEventRepository.findById(id).get();
    }

    public SellingEvent getSellingEvent(Long id) {
        return sellingEventRepository.findById(id).get();
    }
}
