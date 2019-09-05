package com.cloudera.stockcalculator.repository;

import com.cloudera.stockcalculator.model.SellingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellingEventRepository extends JpaRepository<SellingEvent, Long> {
}
