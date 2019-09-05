package com.cloudera.stockcalculator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class StockPrice extends BaseEntity {

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private Long stockPrice;

    @Column
    private Currency stockCurrency = Currency.USD;
}
