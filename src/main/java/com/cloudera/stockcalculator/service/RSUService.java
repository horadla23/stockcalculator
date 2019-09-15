package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.api.dto.SellingEventDto;
import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.dto.taxation.SellingTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.VestingTaxInformation;
import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import com.cloudera.stockcalculator.persistence.model.SellingEvent;
import com.cloudera.stockcalculator.persistence.model.StockType;
import com.cloudera.stockcalculator.persistence.model.VestingEvent;
import com.cloudera.stockcalculator.persistence.repository.SellingEventRepository;
import com.cloudera.stockcalculator.persistence.repository.VestingEventRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RSUService {

    @Inject
    private VestingEventRepository vestingEventRepository;

    @Inject
    private SellingEventRepository sellingEventRepository;

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

    public VestingEvent addNewVesting(Date date, Integer quantity, BigDecimal stockPrice) {
        VestingEvent vestingEvent = new VestingEvent();
        vestingEvent.setStockPrice(stockPrice);
        vestingEvent.setQuantity(quantity);
        vestingEvent.setVestingDate(date);
        vestingEvent.setStockType(StockType.CLOUDERA);
        return vestingEventRepository.save(vestingEvent);
    }

    public SellingEvent addNewSelling(Date date, Integer quantity, BigDecimal stockPrice, BigDecimal additionalFee, Long vestingId) {
        VestingEvent vestingEvent = getVestingEvent(vestingId);

        SellingEvent sellingEvent = new SellingEvent();
        sellingEvent.setVestingEvent(vestingEvent);
        sellingEvent.setSettlementDate(date);
        sellingEvent.setAdditionalFee(additionalFee);
        sellingEvent.setSoldQuantity(quantity);
        sellingEvent.setSoldPrice(stockPrice);
        return sellingEventRepository.save(sellingEvent);
    }

    public VestingTaxInformation getTaxationInformationAboutVesting(VestingEventDto vestingEventDto, TaxationType taxationType) {
        CurrencyRate currencyRate = currencyCurrencyRateProviderMap.get(taxationType.getCurrency())
                .getCurrencyRate(StockType.CLOUDERA.getCurrency(), vestingEventDto.getVestingDate());
        return taxInformationProviderMap.get(taxationType).getTaxationInformationAboutVesting(vestingEventDto, currencyRate);
    }

    public SellingTaxInformation getTaxationInformationAboutSelling(VestingEventDto vestingEventDto, SellingEventDto sellingEventDto, TaxationType taxationType) {
        CurrencyRate currencyRate = currencyCurrencyRateProviderMap.get(taxationType.getCurrency())
                .getCurrencyRate(StockType.CLOUDERA.getCurrency(), sellingEventDto.getSettlementDate());
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
