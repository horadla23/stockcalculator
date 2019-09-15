package com.cloudera.stockcalculator.persistence.model;

import com.cloudera.stockcalculator.service.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StockType {
    CLOUDERA("CLDR", Currency.USD);

    private String symbol;

    private Currency currency;
}
