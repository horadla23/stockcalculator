package com.cloudera.stockcalculator.api.mapper;

import com.cloudera.stockcalculator.api.dto.PurchaseEventDto;
import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.persistence.model.PurchaseEvent;
import com.cloudera.stockcalculator.persistence.model.VestingEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PurchaseEventMapper {

    PurchaseEventMapper INSTANCE = Mappers.getMapper( PurchaseEventMapper.class );

    PurchaseEventDto purchaseEventToPurchaseEventDto(PurchaseEvent purchaseEvent);
}
