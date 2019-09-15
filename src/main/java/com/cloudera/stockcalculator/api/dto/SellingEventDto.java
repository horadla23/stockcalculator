package com.cloudera.stockcalculator.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SellingEventDto {

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date settlementDate;

    private Integer soldQuantity;

    private BigDecimal soldPrice;

    private BigDecimal additionalFee;

}
