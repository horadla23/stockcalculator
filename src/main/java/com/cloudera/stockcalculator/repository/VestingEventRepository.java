package com.cloudera.stockcalculator.repository;

import com.cloudera.stockcalculator.model.VestingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VestingEventRepository extends JpaRepository<VestingEvent, Long> {
}
