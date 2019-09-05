package com.cloudera.stockcalculator.repository;

import com.cloudera.stockcalculator.model.StockPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
}
