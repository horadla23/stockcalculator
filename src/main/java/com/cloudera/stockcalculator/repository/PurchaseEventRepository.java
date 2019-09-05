package com.cloudera.stockcalculator.repository;

import com.cloudera.stockcalculator.model.PurchaseEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseEventRepository extends JpaRepository<PurchaseEvent, Long> {
}
