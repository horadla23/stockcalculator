package com.cloudera.stockcalculator.api.controller;

import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.dto.taxation.VestingTaxInformation;
import com.cloudera.stockcalculator.api.mapper.VestingEventMapper;
import com.cloudera.stockcalculator.service.RSUService;
import com.cloudera.stockcalculator.service.TaxInformationProvider;
import com.cloudera.stockcalculator.service.TaxationType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
@RequestMapping("/rsu")
public class RSUController {

    @Inject
    private RSUService rsuService;

    @GetMapping
    public String testPut() {
        Calendar myCalendar = new GregorianCalendar(2019, Calendar.SEPTEMBER, 6);
        rsuService.addNewVesting(myCalendar.getTime(), 100);
        return "OK";
    }

    @GetMapping("{id}")
    public @ResponseBody
    VestingEventDto get(@PathVariable("id") Long id) {
        return VestingEventMapper.INSTANCE.vestingEventToVestingEventDto(rsuService.getVestingEvent(id));
    }

    @GetMapping("{id}/vesting/tax/{taxation}")
    public @ResponseBody
    VestingTaxInformation get(@PathVariable("id") Long id, @PathVariable("taxation") TaxationType taxationType) {
        VestingEventDto vestingEventDto = VestingEventMapper.INSTANCE.vestingEventToVestingEventDto(rsuService.getVestingEvent(id));
        return rsuService.getTaxationInformationAboutVesting(vestingEventDto, taxationType);
    }
}
