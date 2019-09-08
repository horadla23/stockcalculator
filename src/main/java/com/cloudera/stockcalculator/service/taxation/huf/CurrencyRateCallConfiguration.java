package com.cloudera.stockcalculator.service.taxation.huf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CurrencyRateCallConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("arfolyamok.wsdl");
        return marshaller;
    }

    @Bean
    public HungarianCurrencyRateProvider currencyRateProvider(Jaxb2Marshaller marshaller) {
        HungarianCurrencyRateProvider client = new HungarianCurrencyRateProvider();
        client.setDefaultUri("http://www.mnb.hu/webservices/");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }


}
