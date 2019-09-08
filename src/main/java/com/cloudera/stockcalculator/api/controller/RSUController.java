package com.cloudera.stockcalculator.api.controller;

import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.mapper.VestingEventMapper;
import com.cloudera.stockcalculator.service.RSUService;
import hu.mnb.webservices.MNBArfolyamServiceSoapGetExchangeRatesStringFaultFaultMessage;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
@RequestMapping("/rsu")
public class RSUController {

    @Inject
    private RSUService rsuService;

    @GetMapping
    public String testPut() throws ParseException, MNBArfolyamServiceSoapGetExchangeRatesStringFaultFaultMessage, MalformedURLException {
        Calendar myCalendar = new GregorianCalendar(2019, Calendar.SEPTEMBER, 6);
        rsuService.addNewVesting(myCalendar.getTime(), 100);
        return "OK";
    }

    @GetMapping("{id}")
    public @ResponseBody
    VestingEventDto get(@PathVariable("id") Long id) {
        return VestingEventMapper.INSTANCE.vestingEventToVestingEventDto(rsuService.getVestingEvent(id));
    }
}
