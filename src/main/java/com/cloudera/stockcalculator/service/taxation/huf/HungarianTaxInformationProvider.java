package com.cloudera.stockcalculator.service.taxation.huf;

import com.cloudera.stockcalculator.api.dto.PurchaseEventDto;
import com.cloudera.stockcalculator.api.dto.SellingEventDto;
import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.dto.taxation.PurchaseTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.SellingTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.huf.HungarianSellingTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.huf.HungarianVestingTaxInformation;
import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import com.cloudera.stockcalculator.service.TaxInformationProvider;
import com.cloudera.stockcalculator.service.TaxationType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class HungarianTaxInformationProvider implements TaxInformationProvider {

    @Override
    public TaxationType getTaxationType() {
        return TaxationType.HUNGARIAN;
    }

    @Override
    public HungarianVestingTaxInformation getTaxationInformationAboutVesting(VestingEventDto vestingEventDto, CurrencyRate currencyRate) {
        HungarianVestingTaxInformation hungarianVestingTaxInformation = new HungarianVestingTaxInformation();
        hungarianVestingTaxInformation.setIncome(vestingEventDto.getStockPrice()
                .multiply(currencyRate.getRate()).multiply(new BigDecimal(vestingEventDto.getQuantity())));
        hungarianVestingTaxInformation.setNetIncome(hungarianVestingTaxInformation.getIncome().multiply(new BigDecimal(0.84)));
        hungarianVestingTaxInformation.setPersonalTax(hungarianVestingTaxInformation.getNetIncome().multiply(new BigDecimal(0.15)));
        hungarianVestingTaxInformation.setSocialTax(hungarianVestingTaxInformation.getNetIncome().multiply(new BigDecimal(0.195)));
        return hungarianVestingTaxInformation;
    }

    @Override
    public PurchaseTaxInformation getTaxationInformationAboutESPPPurchase(PurchaseEventDto purchaseEventDto, CurrencyRate currencyRate) {
        return null;
    }

    @Override
    public SellingTaxInformation getTaxationInformationAboutStockSell(VestingEventDto vestingEventDto, SellingEventDto sellingEventDto, CurrencyRate currencyRate) {
        HungarianSellingTaxInformation sellingTaxInformation = new HungarianSellingTaxInformation();
        BigDecimal base = currencyRate.getRate().multiply(new BigDecimal(sellingEventDto.getSoldQuantity()));
        sellingTaxInformation.setGain(base.multiply(sellingEventDto.getSoldPrice()).subtract(base.multiply(vestingEventDto.getStockPrice())));
        sellingTaxInformation.setAdditionalFee(sellingEventDto.getAdditionalFee().multiply(currencyRate.getRate()));
        sellingTaxInformation.setPersonalTax(sellingTaxInformation.getGain().multiply(new BigDecimal(0.15)).subtract(sellingTaxInformation.getAdditionalFee()));
        return sellingTaxInformation;
    }
}
