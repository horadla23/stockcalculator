package com.cloudera.stockcalculator.service;

import arfolyamok.wsdl.GetExchangeRatesRequestBody;
import arfolyamok.wsdl.GetExchangeRatesResponseBody;
import arfolyamok.wsdl.ObjectFactory;
import com.cloudera.stockcalculator.persistence.model.CurrencyRate;
import com.cloudera.stockcalculator.persistence.repository.CurrencyRateRepository;
import lombok.extern.java.Log;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.inject.Inject;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

// for HUF
@Log
public class CurrencyRateProvider extends WebServiceGatewaySupport {

    @Inject
    private CurrencyRateRepository currencyRateRepository;

    public CurrencyRate getCurrencyRate(Currency currency, Date date) throws ParserConfigurationException, IOException, SAXException, ParseException {
        Optional<CurrencyRate> byDateAndSource = currencyRateRepository.findByDateAndSource(date, currency);
        if (byDateAndSource.isPresent()) {
            return byDateAndSource.get();
        }
        CurrencyRate currencyRate = getCurrencyRateFromMNB(currency, date);
        return currencyRateRepository.save(currencyRate);
    }

    private CurrencyRate getCurrencyRateFromMNB(Currency currency, Date date) throws ParserConfigurationException, IOException, SAXException, ParseException {
        String dateAsString = getDateString(date);

        String xmlRateResponse = callMNBService(currency, dateAsString);

        Float rate = getRateFromResponseXml(xmlRateResponse);

        CurrencyRate currencyRate = new CurrencyRate();
        currencyRate.setSource(currency);
        currencyRate.setTarget(Currency.HUF);
        currencyRate.setRate(rate);
        currencyRate.setDate(date);
        return currencyRate;
    }

    private Float getRateFromResponseXml(String xmlRateResponse) throws ParserConfigurationException, IOException, SAXException, ParseException {
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        ByteArrayInputStream input = new ByteArrayInputStream(xmlRateResponse.getBytes("UTF-8"));
        Document doc = builder.parse(input);
        Element root = doc.getDocumentElement();
        return DecimalFormat.getInstance(Locale.GERMAN).parse(root.getFirstChild().getFirstChild().getTextContent()).floatValue();
    }

    private String callMNBService(Currency currency, String dateAsString) {
        ObjectFactory factory = new ObjectFactory();
        GetExchangeRatesRequestBody body = new GetExchangeRatesRequestBody();
        body.setCurrencyNames(factory.createGetExchangeRatesRequestBodyCurrencyNames(currency.name()));
        body.setStartDate(factory.createGetExchangeRatesRequestBodyStartDate(dateAsString));
        body.setEndDate(factory.createGetExchangeRatesRequestBodyEndDate(dateAsString));
        JAXBElement<GetExchangeRatesResponseBody> responseBody = (JAXBElement<GetExchangeRatesResponseBody>) getWebServiceTemplate()
                        .marshalSendAndReceive("http://www.mnb.hu/arfolyamok.asmx",
                                new JAXBElement<GetExchangeRatesRequestBody>(
                                        new QName("http://www.mnb.hu/webservices/", "GetExchangeRates"),
                                        GetExchangeRatesRequestBody.class, null, body));
        String xmlRateResponse = responseBody.getValue().getGetExchangeRatesResult().getValue();
        log.info("Response: " + xmlRateResponse);
        return xmlRateResponse;
    }

    private String getDateString(Date date) {
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }
}
