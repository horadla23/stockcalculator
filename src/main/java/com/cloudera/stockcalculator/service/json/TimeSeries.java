package com.cloudera.stockcalculator.service.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.Serializable;
import java.util.Map;

@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
public class TimeSeries implements Serializable {

    @JsonProperty(value = "Time Series (Daily)")
    Map<String, Map<String, String>> timeSeriesByDate;

}
