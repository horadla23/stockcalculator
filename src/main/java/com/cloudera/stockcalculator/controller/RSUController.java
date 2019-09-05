package com.cloudera.stockcalculator.controller;

import com.cloudera.stockcalculator.model.VestingEvent;
import com.cloudera.stockcalculator.service.RSUService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Date;

@RestController
@RequestMapping("/rsu")
public class RSUController {

    @Inject
    private RSUService rsuService;

    @GetMapping
    public String testPut() {
        rsuService.addNewVesting(new Date(), 100, 300L);
        return "OK";
    }

    @GetMapping("{id}")
    public @ResponseBody VestingEvent get(@PathVariable("id") Long id) {
        return rsuService.getVestingEvent(id);
    }
}
