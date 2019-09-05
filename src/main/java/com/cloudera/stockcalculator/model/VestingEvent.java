package com.cloudera.stockcalculator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class VestingEvent extends BaseEntity {

    @OneToOne
    private StockPrice stockPrice;

    @OneToOne
    private CurrencyRate currencyRate;

    @Column
    @Temporal(TemporalType.DATE)
    private Date vestingDate;

    @Column
    private Integer quantity;
}
