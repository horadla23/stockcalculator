package com.cloudera.stockcalculator.api.mapper;

import com.cloudera.stockcalculator.api.dto.StockPriceDto;
import com.cloudera.stockcalculator.persistence.model.StockPrice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StockPriceMapper {

    StockPriceMapper INSTANCE = Mappers.getMapper( StockPriceMapper.class );

    StockPriceDto stockPriceToStockPriceDto(StockPrice stockPrice);
}
