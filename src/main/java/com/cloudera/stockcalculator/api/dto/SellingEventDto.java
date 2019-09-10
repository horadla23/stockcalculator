package com.cloudera.stockcalculator.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SellingEventDto {

    private StockPriceDto settlementPrice;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date settlementDate;

    private Integer soldQuantity;

    private Float soldPrice;

    private Float additionalFee;

}
