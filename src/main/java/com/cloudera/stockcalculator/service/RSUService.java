package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.api.dto.SellingEventDto;
import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.dto.taxation.SellingTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.VestingTaxInformation;
import com.cloudera.stockcalculator.api.mapper.SellingEventMapper;
import com.cloudera.stockcalculator.api.mapper.VestingEventMapper;
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
    private List<TaxInformationProvider> taxInformationProviderList;

    private final Map<TaxationType, TaxInformationProvider> taxInformationProviderMap = new HashMap<>();

    @PostConstruct
    public void populateRateProviderMap() {
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
        return taxInformationProviderMap.get(taxationType).getTaxationInformationAboutVesting(vestingEventDto);
    }

    public SellingTaxInformation getTaxationInformationAboutSelling(SellingEventDto sellingEventDto, TaxationType taxationType) {
        return taxInformationProviderMap.get(taxationType).getTaxationInformationAboutStockSell(sellingEventDto);
    }

    public VestingEvent getVestingEvent(Long id) {
        return vestingEventRepository.findById(id).get();
    }

    public SellingEvent getSellingEvent(Long id) {
        return sellingEventRepository.findById(id).get();
    }

    public Map<Integer, ? extends SellingTaxInformation> getTaxationInformationAboutSellingByYear(TaxationType taxationType) {
        List<SellingEventDto> all = SellingEventMapper.INSTANCE.sellingEventsToSellingEventDtos(sellingEventRepository.findAll());
        return taxInformationProviderMap.get(taxationType).getSellingTaxInfoByYear(all);
    }

    public Map<String, ? extends VestingTaxInformation> getTaxationInformationAboutVestingByYear(TaxationType taxationType) {
        List<VestingEventDto> all = VestingEventMapper.INSTANCE.vestingEventsToVestingEventDtos(vestingEventRepository.findAll());
        return taxInformationProviderMap.get(taxationType).getVestingTaxInfoByYear(all);
    }
}
