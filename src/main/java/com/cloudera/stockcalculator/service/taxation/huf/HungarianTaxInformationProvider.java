package com.cloudera.stockcalculator.service.taxation.huf;

import com.cloudera.stockcalculator.api.dto.PurchaseEventDto;
import com.cloudera.stockcalculator.api.dto.SellingEventDto;
import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.dto.taxation.PurchaseTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.SellingTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.VestingTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.huf.HungarianVestingTaxInformation;
import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import com.cloudera.stockcalculator.service.TaxInformationProvider;
import com.cloudera.stockcalculator.service.TaxationType;
import org.springframework.stereotype.Service;

@Service
public class HungarianTaxInformationProvider implements TaxInformationProvider {

    @Override
    public TaxationType getTaxationType() {
        return TaxationType.HUNGARIAN;
    }

    @Override
    public HungarianVestingTaxInformation getTaxationInformationAboutVesting(VestingEventDto vestingEventDto, CurrencyRate currencyRate) {
        HungarianVestingTaxInformation hungarianVestingTaxInformation = new HungarianVestingTaxInformation();
        hungarianVestingTaxInformation.setIncome(vestingEventDto.getQuantity() * vestingEventDto.getStockPrice().getStockPrice()
            * currencyRate.getRate());
        hungarianVestingTaxInformation.setNetIncome((float) (hungarianVestingTaxInformation.getIncome() * 0.84));
        hungarianVestingTaxInformation.setPersonalTax((float) (hungarianVestingTaxInformation.getNetIncome() * 0.15));
        hungarianVestingTaxInformation.setSocialTax((float) (hungarianVestingTaxInformation.getNetIncome() * 0.195));
        return hungarianVestingTaxInformation;
    }

    @Override
    public PurchaseTaxInformation getTaxationInformationAboutESPPPurchase(PurchaseEventDto purchaseEventDto, CurrencyRate currencyRate) {
        return null;
    }

    @Override
    public SellingTaxInformation getTaxationInformationAboutStockSell(SellingEventDto sellingEventDto, CurrencyRate currencyRate) {
        return null;
    }
}
