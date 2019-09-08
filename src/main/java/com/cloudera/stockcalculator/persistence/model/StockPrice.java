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
public class StockPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private Float stockPrice;

    @Enumerated(EnumType.STRING)
    @Column
    private Currency stockCurrency;
}
