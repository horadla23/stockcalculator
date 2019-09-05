package com.cloudera.stockcalculator.service.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.Map;

@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
public class TimeSeriesData {

    private Map<String, String> values;
}
