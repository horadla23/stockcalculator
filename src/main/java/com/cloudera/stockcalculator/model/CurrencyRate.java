package com.cloudera.stockcalculator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CurrencyRate extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency source = Currency.USD;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency target = Currency.HUF;

    @Column(nullable = false)
    private Long rate;
}
