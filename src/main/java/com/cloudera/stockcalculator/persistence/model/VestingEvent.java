package com.cloudera.stockcalculator.persistence.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class VestingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private BigDecimal stockPrice;

    @Column
    @Temporal(TemporalType.DATE)
    private Date vestingDate;

    @Column
    private Integer quantity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StockType stockType;
}
