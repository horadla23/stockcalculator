package com.cloudera.stockcalculator.api.mapper;

import com.cloudera.stockcalculator.api.dto.CurrencyRateDto;
import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CurrencyRateMapper {

    CurrencyRateMapper INSTANCE = Mappers.getMapper( CurrencyRateMapper.class );

    CurrencyRateDto currencyRateToCurrencyRateDto(CurrencyRate currencyRate);
}
