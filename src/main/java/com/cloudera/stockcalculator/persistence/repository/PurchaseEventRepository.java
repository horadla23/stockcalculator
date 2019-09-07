package com.cloudera.stockcalculator.persistence.repository;

import com.cloudera.stockcalculator.persistence.model.PurchaseEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseEventRepository extends JpaRepository<PurchaseEvent, Long> {
}
