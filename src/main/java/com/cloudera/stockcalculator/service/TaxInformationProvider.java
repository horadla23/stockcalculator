package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.api.dto.PurchaseEventDto;
import com.cloudera.stockcalculator.api.dto.SellingEventDto;
import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.dto.taxation.PurchaseTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.SellingTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.VestingTaxInformation;

import java.util.List;
import java.util.Map;

public interface TaxInformationProvider {

    TaxationType getTaxationType();

    VestingTaxInformation getTaxationInformationAboutVesting(VestingEventDto vestingEventDto);

    PurchaseTaxInformation getTaxationInformationAboutESPPPurchase(PurchaseEventDto purchaseEventDto);

    SellingTaxInformation getTaxationInformationAboutStockSell(SellingEventDto sellingEventDto);

    Map<Integer, ? extends SellingTaxInformation> getSellingTaxInfoByYear(List<SellingEventDto> sellingEvents);
}
