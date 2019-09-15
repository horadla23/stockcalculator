package com.cloudera.stockcalculator.api.dto.taxation.huf;

import com.cloudera.stockcalculator.api.dto.taxation.VestingTaxInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HungarianVestingTaxInformation extends VestingTaxInformation {

    private BigDecimal income;

    private BigDecimal netIncome;

    private BigDecimal socialTax;

    private BigDecimal personalTax;
}
