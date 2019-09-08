package com.cloudera.stockcalculator.persistence.model;

import com.cloudera.stockcalculator.service.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SellingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
    private Float additionalFee;

    @Column
    @Enumerated(EnumType.STRING)
    private Currency additionalFeeCurrency;
}
