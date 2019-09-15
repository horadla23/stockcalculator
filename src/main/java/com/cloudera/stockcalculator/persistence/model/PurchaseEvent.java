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
public class PurchaseEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date enrollmentDate;

    @Column
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    @Column
    private BigDecimal enrollmentPrice;

    @Column
    private BigDecimal purchasePrice;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StockType stockType;
}
