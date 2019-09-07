package com.cloudera.stockcalculator.api.dto;

import com.cloudera.stockcalculator.persistence.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRateDto {

    private Currency source;

    private Currency target;

    private Float rate;
}
