package com.cloudera.stockcalculator.api.dto;

import com.cloudera.stockcalculator.service.Currency;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    private Float stockPrice;

    private Currency stockCurrency;
}
