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
public class SellingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private VestingEvent vestingEvent;

    @OneToOne
    private StockPrice settlementPrice;

    @Column
    @Temporal(TemporalType.DATE)
    private Date settlementDate;

    @Column
    private Integer soldQuantity;

    @Column
    private Float soldPrice;

    @Column
    private Float additionalFee;
}
