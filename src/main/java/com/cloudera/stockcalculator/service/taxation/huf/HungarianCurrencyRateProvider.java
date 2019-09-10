package com.cloudera.stockcalculator.service.taxation.huf;

import arfolyamok.wsdl.GetExchangeRatesRequestBody;
import arfolyamok.wsdl.GetExchangeRatesResponseBody;
import arfolyamok.wsdl.ObjectFactory;
import com.cloudera.stockcalculator.persistence.repository.CurrencyRateRepository;
import com.cloudera.stockcalculator.service.Currency;
import com.cloudera.stockcalculator.service.CurrencyRateProvider;
import lombok.extern.java.Log;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Log
public class HungarianCurrencyRateProvider extends WebServiceGatewaySupport implements CurrencyRateProvider {

    @Inject
    private CurrencyRateRepository currencyRateRepository;

    @Override
    public Currency getTargetCurrency() {
        return Currency.HUF;
    }

    @Override
    public CurrencyRateRepository getCurrencyRateRepository() {
        return currencyRateRepository;
    }

    @Override
    public Float getRate(Currency sourceCurrency, Date date) {
        try {
            return getCurrencyRateFromMNB(sourceCurrency, date);
        } catch (Exception e) {
            log.info(e.getMessage());
            throw new BadRequestException("Exception during getting currency rate!", e);
        }
    }

    private Float getCurrencyRateFromMNB(Currency sourceCurrency, Date date) throws ParserConfigurationException, IOException, SAXException, ParseException {
        String xmlRateResponse = callMNBService(sourceCurrency, date);
        return getRateFromResponseXml(xmlRateResponse);
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

    private String callMNBService(Currency currency, Date date) {
        String dateAsString = getDateString(date);
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
