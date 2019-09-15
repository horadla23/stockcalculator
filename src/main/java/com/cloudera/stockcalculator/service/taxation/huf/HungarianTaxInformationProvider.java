package com.cloudera.stockcalculator.service.taxation.huf;

import com.cloudera.stockcalculator.api.dto.PurchaseEventDto;
import com.cloudera.stockcalculator.api.dto.SellingEventDto;
import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.dto.taxation.PurchaseTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.huf.HungarianSellingTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.huf.HungarianVestingTaxInformation;
import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import com.cloudera.stockcalculator.service.TaxInformationProvider;
import com.cloudera.stockcalculator.service.TaxationType;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

@Service
public class HungarianTaxInformationProvider implements TaxInformationProvider {

    @Inject
    private HungarianCurrencyRateProvider rateProvider;

    @Override
    public TaxationType getTaxationType() {
        return TaxationType.HUNGARIAN;
    }

    @Override
    public HungarianVestingTaxInformation getTaxationInformationAboutVesting(VestingEventDto vestingEventDto) {
        CurrencyRate currencyRate = rateProvider
                .getCurrencyRate(vestingEventDto.getStockType().getCurrency(), vestingEventDto.getVestingDate());
        HungarianVestingTaxInformation hungarianVestingTaxInformation = new HungarianVestingTaxInformation();
        hungarianVestingTaxInformation.setIncome(vestingEventDto.getStockPrice()
                .multiply(currencyRate.getRate()).multiply(new BigDecimal(vestingEventDto.getQuantity())));
        hungarianVestingTaxInformation.setNetIncome(hungarianVestingTaxInformation.getIncome().multiply(new BigDecimal(0.84)));
        hungarianVestingTaxInformation.setPersonalTax(hungarianVestingTaxInformation.getNetIncome().multiply(new BigDecimal(0.15)));
        hungarianVestingTaxInformation.setSocialTax(hungarianVestingTaxInformation.getNetIncome().multiply(new BigDecimal(0.195)));
        return hungarianVestingTaxInformation;
    }

    @Override
    public PurchaseTaxInformation getTaxationInformationAboutESPPPurchase(PurchaseEventDto purchaseEventDto) {
        return null;
    }

    @Override
    public HungarianSellingTaxInformation getTaxationInformationAboutStockSell(SellingEventDto sellingEventDto) {
        CurrencyRate currencyRate = rateProvider
                .getCurrencyRate(sellingEventDto.getVestingEvent().getStockType().getCurrency(), sellingEventDto.getSettlementDate());
        HungarianSellingTaxInformation sellingTaxInformation = new HungarianSellingTaxInformation();
        BigDecimal base = currencyRate.getRate().multiply(new BigDecimal(sellingEventDto.getSoldQuantity()));
        sellingTaxInformation.setGain(base.multiply(sellingEventDto.getSoldPrice()).subtract(base.multiply(sellingEventDto.getVestingEvent().getStockPrice())));
        sellingTaxInformation.setAdditionalFee(sellingEventDto.getAdditionalFee().multiply(currencyRate.getRate()));
        sellingTaxInformation.setPersonalTax(sellingTaxInformation.getGain().multiply(new BigDecimal(0.15)).subtract(sellingTaxInformation.getAdditionalFee()));
        return sellingTaxInformation;
    }

    @Override
    public Map<Integer, HungarianSellingTaxInformation> getSellingTaxInfoByYear(List<SellingEventDto> sellingEvents) {
        Map<Integer, List<BigDecimal>> additionalFeeMap = Maps.newConcurrentMap();
        Map<Integer, List<BigDecimal>> gainMap = Maps.newConcurrentMap();
        sellingEvents.forEach(sellingEventDto -> {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTime(sellingEventDto.getSettlementDate());
            Integer year = cal.get(Calendar.YEAR);
            HungarianSellingTaxInformation sellingTaxInformation = getTaxationInformationAboutStockSell(sellingEventDto);
            if (gainMap.containsKey(year)) {
                gainMap.get(year).add(sellingTaxInformation.getGain());
                additionalFeeMap.get(year).add(sellingTaxInformation.getAdditionalFee());
            } else {
                gainMap.put(year, Lists.newArrayList(sellingTaxInformation.getGain()));
                additionalFeeMap.put(year, Lists.newArrayList(sellingTaxInformation.getAdditionalFee()));
            }
        });
        Map<Integer, HungarianSellingTaxInformation> result = Maps.newHashMap();
        gainMap.keySet().stream().forEach(year -> {
            HungarianSellingTaxInformation tax = new HungarianSellingTaxInformation();
            tax.setGain(gainMap.get(year).stream().reduce(BigDecimal.ZERO, BigDecimal::add));
            tax.setAdditionalFee(additionalFeeMap.get(year).stream().reduce(BigDecimal.ZERO, BigDecimal::add));
            tax.setPersonalTax(tax.getGain().subtract(tax.getAdditionalFee()).multiply(new BigDecimal(0.15)));
            result.put(year, tax);
        });
        return result;
    }
}
