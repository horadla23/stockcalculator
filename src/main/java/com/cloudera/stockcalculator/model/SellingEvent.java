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
public class SellingEvent extends BaseEntity {

    @OneToOne
    private StockPrice vestingPrice;

    @OneToOne
    private StockPrice settlementPrice;

    @OneToOne
    private CurrencyRate settlementRate;

    @Column
    @Temporal(TemporalType.DATE)
    private Date settlementDate;

    @Column
    private Integer soldQuantity;

    @Column
    private Long additionalFee;

    @Column
    @Enumerated(EnumType.STRING)
    private Currency additionalFeeCurrency;
}
