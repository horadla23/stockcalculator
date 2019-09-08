package com.cloudera.stockcalculator.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StockType {
    CLOUDERA("CLDR", Currency.USD);

    private String symbol;

    private Currency currency;
}
