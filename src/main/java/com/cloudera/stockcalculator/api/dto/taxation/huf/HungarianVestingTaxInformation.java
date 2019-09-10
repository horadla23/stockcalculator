package com.cloudera.stockcalculator.api.dto.taxation.huf;

import com.cloudera.stockcalculator.api.dto.taxation.VestingTaxInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HungarianVestingTaxInformation extends VestingTaxInformation {

    private Integer income;

    private Integer netIncome;

    private Integer socialTax;

    private Integer personalTax;
}
