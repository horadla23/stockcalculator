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

@Service
public class HungarianTaxInformationProvider implements TaxInformationProvider {

    @Override
    public TaxationType getTaxationType() {
        return TaxationType.HUNGARIAN;
    }

    @Override
    public HungarianVestingTaxInformation getTaxationInformationAboutVesting(VestingEventDto vestingEventDto, CurrencyRate currencyRate) {
        HungarianVestingTaxInformation hungarianVestingTaxInformation = new HungarianVestingTaxInformation();
        hungarianVestingTaxInformation.setIncome((int) (vestingEventDto.getQuantity()
                * vestingEventDto.getStockPrice().getStockPrice() * currencyRate.getRate()));
        hungarianVestingTaxInformation.setNetIncome((int) (hungarianVestingTaxInformation.getIncome() * 0.84));
        hungarianVestingTaxInformation.setPersonalTax((int) (hungarianVestingTaxInformation.getNetIncome() * 0.15));
        hungarianVestingTaxInformation.setSocialTax((int) (hungarianVestingTaxInformation.getNetIncome() * 0.195));
        return hungarianVestingTaxInformation;
    }

    @Override
    public PurchaseTaxInformation getTaxationInformationAboutESPPPurchase(PurchaseEventDto purchaseEventDto, CurrencyRate currencyRate) {
        return null;
    }

    @Override
    public SellingTaxInformation getTaxationInformationAboutStockSell(VestingEventDto vestingEventDto, SellingEventDto sellingEventDto, CurrencyRate currencyRate) {
        HungarianSellingTaxInformation sellingTaxInformation = new HungarianSellingTaxInformation();
        Float base = currencyRate.getRate() * sellingEventDto.getSoldQuantity();
        sellingTaxInformation.setGain((int) (base * sellingEventDto.getSettlementPrice().getStockPrice() - base * vestingEventDto.getStockPrice().getStockPrice()));
        sellingTaxInformation.setAdditionalFee((int) (sellingEventDto.getAdditionalFee() * currencyRate.getRate()));
        sellingTaxInformation.setPersonalTax((int) (sellingTaxInformation.getGain() * 0.15 - sellingTaxInformation.getAdditionalFee()));
        return sellingTaxInformation;
    }
}
