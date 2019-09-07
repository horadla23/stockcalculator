package com.cloudera.stockcalculator.api.dto;

import com.cloudera.stockcalculator.persistence.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockPriceDto {

    private Date date;

    private Float stockPrice;

    private Currency stockCurrency;
}
