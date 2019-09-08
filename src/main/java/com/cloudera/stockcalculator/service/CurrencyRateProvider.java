package com.cloudera.stockcalculator.service;

import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import com.microsoft.schemas._2003._10.serialization.ObjectFactory;
import hu.mnb.webservices.*;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBElement;
import java.net.MalformedURLException;
import java.net.URL;

// for HUF
@Log
@Service
public class CurrencyRateProvider {

    public CurrencyRate getCurrencyRate(Currency currency) throws MNBArfolyamServiceSoapGetExchangeRatesStringFaultFaultMessage, MalformedURLException {
        MNBArfolyamServiceSoapImpl impl = new MNBArfolyamServiceSoapImpl(
                new URL("file:/app/wsdl/arfolyamok.asmx.xml"));
        MNBArfolyamServiceSoap service = impl.getCustomBindingMNBArfolyamServiceSoap();
        GetExchangeRatesRequestBody exchangeRateBody = new GetExchangeRatesRequestBody();
        ObjectFactory factory = new ObjectFactory();
        JAXBElement<String> jaxbCurrency = factory.createString(currency.name());
        exchangeRateBody.setCurrencyNames(jaxbCurrency);
        GetExchangeRatesResponseBody exchangeRates = service.getExchangeRates(exchangeRateBody);
        String value = exchangeRates.getGetExchangeRatesResult().getValue();
        log.info(value);
        return null;
    }
}
