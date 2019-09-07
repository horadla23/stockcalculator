package com.cloudera.stockcalculator.persistence.repository;

import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {
}
