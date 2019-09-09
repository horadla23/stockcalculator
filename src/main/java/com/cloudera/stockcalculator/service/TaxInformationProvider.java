package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.api.dto.PurchaseEventDto;
import com.cloudera.stockcalculator.api.dto.SellingEventDto;
import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.dto.taxation.PurchaseTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.SellingTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.VestingTaxInformation;
import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import com.cloudera.stockcalculator.persistence.repository.CurrencyRateRepository;

import java.util.Date;
import java.util.Optional;

public interface TaxInformationProvider {

    TaxationType getTaxationType();

    VestingTaxInformation getTaxationInformationAboutVesting(VestingEventDto vestingEventDto, CurrencyRate currencyRate);

    PurchaseTaxInformation getTaxationInformationAboutESPPPurchase(PurchaseEventDto purchaseEventDto, CurrencyRate currencyRate);

    SellingTaxInformation getTaxationInformationAboutStockSell(SellingEventDto sellingEventDto, CurrencyRate currencyRate);
}
