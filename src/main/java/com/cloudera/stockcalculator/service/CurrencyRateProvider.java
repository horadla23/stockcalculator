package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import com.cloudera.stockcalculator.persistence.repository.CurrencyRateRepository;

import java.util.Date;
import java.util.Optional;

public interface CurrencyRateProvider {

    Currency getTargetCurrency();

    CurrencyRateRepository getCurrencyRateRepository();

    Float getRate(Currency sourceCurrency, Date date);

    default CurrencyRate getCurrencyRate(Currency sourceCurrency, Date date) {
        Optional<CurrencyRate> byDateAndSource = getCurrencyRateRepository().findByDateAndSource(date, sourceCurrency);
        if (byDateAndSource.isPresent()) {
            return byDateAndSource.get();
        }
        Float rate = getRate(sourceCurrency, date);
        CurrencyRate currencyRate = new CurrencyRate();
        currencyRate.setSource(sourceCurrency);
        currencyRate.setTarget(getTargetCurrency());
        currencyRate.setRate(rate);
        currencyRate.setDate(date);
        return getCurrencyRateRepository().save(currencyRate);
    }
}
