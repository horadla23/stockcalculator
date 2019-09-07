package com.cloudera.stockcalculator.persistence.repository;

import com.cloudera.stockcalculator.persistence.model.VestingEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VestingEventRepository extends JpaRepository<VestingEvent, Long> {
}
