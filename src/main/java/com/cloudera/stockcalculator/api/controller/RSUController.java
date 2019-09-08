package com.cloudera.stockcalculator.api.controller;

import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.mapper.VestingEventMapper;
import com.cloudera.stockcalculator.service.RSUService;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.inject.Inject;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
@RequestMapping("/rsu")
public class RSUController {

    @Inject
    private RSUService rsuService;

    @GetMapping
    public String testPut() throws ParserConfigurationException, SAXException, IOException, ParseException {
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
