package com.cloudera.stockcalculator.repository;

import com.cloudera.stockcalculator.model.VestingEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VestingEventRepository extends JpaRepository<VestingEvent, Long> {
}
