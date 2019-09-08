package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.persistence.model.StockPrice;
import com.cloudera.stockcalculator.service.json.TimeSeries;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.BadRequestException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class StockPriceProvider {

    private static final String ALPHA_API_KEY = "GLZ1EP7H6DFY2HQU";

    public StockPrice getStockPrice(Date date, StockType stockType) {
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        String dateAsString = df.format(date);

        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + stockType.getSymbol()
                + "&apikey=" + ALPHA_API_KEY;
        TimeSeries object = restTemplate.getForObject(resourceUrl, TimeSeries.class);

        StockPrice stockPrice = new StockPrice();
        stockPrice.setDate(date);
        stockPrice.setStockCurrency(Currency.USD);
        if (object.getTimeSeriesByDate().containsKey(dateAsString) &&
                object.getTimeSeriesByDate().get(dateAsString).containsKey("4. close")) {
            stockPrice.setStockPrice(Float.parseFloat(object.getTimeSeriesByDate().get(dateAsString).get("4. close")));
        } else {
            throw new BadRequestException("Date is not valid, no stock data have found or stock is not closed for that date.");
        }
        return stockPrice;
    }
}
