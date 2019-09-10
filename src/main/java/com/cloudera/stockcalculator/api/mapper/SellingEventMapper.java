package com.cloudera.stockcalculator.api.mapper;

import com.cloudera.stockcalculator.api.dto.SellingEventDto;
import com.cloudera.stockcalculator.persistence.model.SellingEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SellingEventMapper {

    SellingEventMapper INSTANCE = Mappers.getMapper( SellingEventMapper.class );

    SellingEventDto sellingEventToSellingEventDto(SellingEvent sellingEvent);
}
