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

    private Float income;

    private Float netIncome;

    private Float socialTax;

    private Float personalTax;
}
