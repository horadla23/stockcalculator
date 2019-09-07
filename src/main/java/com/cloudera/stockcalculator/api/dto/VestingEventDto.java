package com.cloudera.stockcalculator.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VestingEventDto {

    private StockPriceDto stockPrice;

    private CurrencyRateDto currencyRate;

    private Date vestingDate;

    private Integer quantity;
}
