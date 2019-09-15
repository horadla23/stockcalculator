package com.cloudera.stockcalculator.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaxationType {
    HUNGARIAN(Currency.HUF);

    private Currency currency;
}
