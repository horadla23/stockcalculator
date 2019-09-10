package com.cloudera.stockcalculator.api.dto.taxation.huf;

import com.cloudera.stockcalculator.api.dto.taxation.SellingTaxInformation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HungarianSellingTaxInformation extends SellingTaxInformation {

    private Integer gain;

    private Integer additionalFee;

    private Integer personalTax;
}
