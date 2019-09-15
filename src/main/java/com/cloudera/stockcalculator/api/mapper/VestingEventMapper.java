package com.cloudera.stockcalculator.api.mapper;

import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.persistence.model.VestingEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VestingEventMapper {

    VestingEventMapper INSTANCE = Mappers.getMapper( VestingEventMapper.class );

    VestingEventDto vestingEventToVestingEventDto(VestingEvent vestingEvent);

    List<VestingEventDto> vestingEventsToVestingEventDtos(List<VestingEvent> vestingEvents);
}
