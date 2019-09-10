package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.persistence.model.StockPrice;
import com.cloudera.stockcalculator.persistence.repository.StockPriceRepository;
import com.cloudera.stockcalculator.service.json.TimeSeries;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Log
@Service
public class StockPriceProvider {

    private static final String ALPHA_API_KEY = "GLZ1EP7H6DFY2HQU";

    @Inject
    private StockPriceRepository stockPriceRepository;

    public StockPrice getStockPrice(Date date, StockType stockType) {
        Optional<StockPrice> byDateAndStockCurrency = stockPriceRepository.findByDateAndStockCurrency(date, stockType.getCurrency());
        if (byDateAndStockCurrency.isPresent()) {
            return byDateAndStockCurrency.get();
        }
        TimeSeries object = callAlphaForStockPrice(stockType);
        StockPrice stockPrice = getStockPriceFromTimeSeriesObject(date, object);
        return stockPriceRepository.save(stockPrice);
    }

    private StockPrice getStockPriceFromTimeSeriesObject(Date date, TimeSeries object) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.setDate(date);
        stockPrice.setStockCurrency(Currency.USD);
        String dateAsString = getDateString(date);
        if (object.getTimeSeriesByDate().containsKey(dateAsString) &&
                object.getTimeSeriesByDate().get(dateAsString).containsKey("4. close")) {
            stockPrice.setStockPrice(Float.parseFloat(object.getTimeSeriesByDate().get(dateAsString).get("4. close")));
        } else {
            log.warning("Date is not valid, no stock data have found or stock is not closed for that date.");
            return getStockPriceFromTimeSeriesObject(subtractDate(date), object);
        }
        return stockPrice;
    }

    private Date subtractDate(Date original) {
        LocalDateTime localDateTime = original.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.minusDays(1);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    private TimeSeries callAlphaForStockPrice(StockType stockType) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + stockType.getSymbol()
                + "&apikey=" + ALPHA_API_KEY;
        return restTemplate.getForObject(resourceUrl, TimeSeries.class);
    }

    private String getDateString(Date date) {
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }
}
