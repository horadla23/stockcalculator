package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.api.dto.PurchaseEventDto;
import com.cloudera.stockcalculator.api.dto.SellingEventDto;
import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.dto.taxation.PurchaseTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.SellingTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.VestingTaxInformation;
import com.cloudera.stockcalculator.persistence.model.CurrencyRate;

public interface TaxInformationProvider {

    TaxationType getTaxationType();

    VestingTaxInformation getTaxationInformationAboutVesting(VestingEventDto vestingEventDto, CurrencyRate currencyRate);

    PurchaseTaxInformation getTaxationInformationAboutESPPPurchase(PurchaseEventDto purchaseEventDto, CurrencyRate currencyRate);

    SellingTaxInformation getTaxationInformationAboutStockSell(VestingEventDto vestingEventDto, SellingEventDto sellingEventDto, CurrencyRate currencyRate);
}
