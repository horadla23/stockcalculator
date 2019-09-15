package com.cloudera.stockcalculator.api.dto;

import com.cloudera.stockcalculator.persistence.model.StockType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VestingEventDto {

    private BigDecimal stockPrice;

    private StockType stockType;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date vestingDate;

    private Integer quantity;
}
