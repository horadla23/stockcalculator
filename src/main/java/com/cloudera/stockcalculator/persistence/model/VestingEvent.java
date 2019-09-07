package com.cloudera.stockcalculator.persistence.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class VestingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
