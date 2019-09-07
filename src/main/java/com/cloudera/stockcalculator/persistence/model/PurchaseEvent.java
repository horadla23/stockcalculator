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

    @OneToOne
    private StockPrice enrollmentPrice;

    @OneToOne
    private StockPrice purchasePrice;

    @Column
    private Integer source;

    @Column
    @Enumerated(EnumType.STRING)
    private Currency sourceCurrency;
}
