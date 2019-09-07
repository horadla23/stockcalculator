package com.cloudera.stockcalculator.persistence.repository;

import com.cloudera.stockcalculator.persistence.model.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
}
