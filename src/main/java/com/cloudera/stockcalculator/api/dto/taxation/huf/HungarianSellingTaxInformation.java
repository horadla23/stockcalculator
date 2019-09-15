package com.cloudera.stockcalculator.api.dto.taxation.huf;

import com.cloudera.stockcalculator.api.dto.taxation.SellingTaxInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HungarianSellingTaxInformation extends SellingTaxInformation {

    private BigDecimal gain;

    private BigDecimal additionalFee;

    private BigDecimal personalTax;
}
