package com.cloudera.stockcalculator.repository;

import com.cloudera.stockcalculator.model.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {
}
