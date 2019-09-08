package com.cloudera.stockcalculator.persistence.model;

import com.cloudera.stockcalculator.service.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency source = Currency.USD;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency target = Currency.HUF;

    @Column(nullable = false)
    private Float rate;
}