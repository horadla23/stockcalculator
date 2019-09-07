package com.cloudera.stockcalculator.persistence.repository;

import com.cloudera.stockcalculator.persistence.model.SellingEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellingEventRepository extends JpaRepository<SellingEvent, Long> {
}
