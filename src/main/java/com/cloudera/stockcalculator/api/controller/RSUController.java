package com.cloudera.stockcalculator.api.controller;

import com.cloudera.stockcalculator.api.dto.SellingEventDto;
import com.cloudera.stockcalculator.api.dto.VestingEventDto;
import com.cloudera.stockcalculator.api.dto.taxation.SellingTaxInformation;
import com.cloudera.stockcalculator.api.dto.taxation.VestingTaxInformation;
import com.cloudera.stockcalculator.api.mapper.SellingEventMapper;
import com.cloudera.stockcalculator.api.mapper.VestingEventMapper;
import com.cloudera.stockcalculator.persistence.model.SellingEvent;
import com.cloudera.stockcalculator.service.RSUService;
import com.cloudera.stockcalculator.service.TaxationType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping("/rsu")
public class RSUController {

    @Inject
    private RSUService rsuService;

    @PostMapping("/vesting")
    public VestingEventDto addVestingEvent(@RequestBody VestingEventDto vestingEventDto) {
        return VestingEventMapper.INSTANCE.vestingEventToVestingEventDto(
                rsuService.addNewVesting(vestingEventDto.getVestingDate(), vestingEventDto.getQuantity(),
                        vestingEventDto.getStockPrice()));
    }

    @GetMapping("/vesting/{id}")
    public @ResponseBody
    VestingEventDto getVestingEvent(@PathVariable("id") Long id) {
        return VestingEventMapper.INSTANCE.vestingEventToVestingEventDto(rsuService.getVestingEvent(id));
    }

    @GetMapping("/vesting/{id}/tax/{taxation}")
    public @ResponseBody
    VestingTaxInformation getVestingTaxInformation(@PathVariable("id") Long id, @PathVariable("taxation") TaxationType taxationType) {
        VestingEventDto vestingEventDto = VestingEventMapper.INSTANCE.vestingEventToVestingEventDto(rsuService.getVestingEvent(id));
        return rsuService.getTaxationInformationAboutVesting(vestingEventDto, taxationType);
    }

    @PostMapping("/selling/{vestingId}")
    public SellingEventDto addSellingEvent(@RequestBody SellingEventDto sellingEventDto, @PathVariable("vestingId") Long vestingId) {
        return SellingEventMapper.INSTANCE.sellingEventToSellingEventDto(rsuService.addNewSelling(sellingEventDto.getSettlementDate(),
                sellingEventDto.getSoldQuantity(), sellingEventDto.getSoldPrice(), sellingEventDto.getAdditionalFee(), vestingId));
    }

    @GetMapping("/selling/{id}")
    public @ResponseBody
    SellingEventDto getSellingEvent(@PathVariable("id") Long id) {
        return SellingEventMapper.INSTANCE.sellingEventToSellingEventDto(rsuService.getSellingEvent(id));
    }

    @GetMapping("/selling/{id}/tax/{taxation}")
    public @ResponseBody
    SellingTaxInformation getSellingTaxInformation(@PathVariable("id") Long id, @PathVariable("taxation") TaxationType taxationType) {
        SellingEvent sellingEvent = rsuService.getSellingEvent(id);
        SellingEventDto sellingEventDto = SellingEventMapper.INSTANCE.sellingEventToSellingEventDto(sellingEvent);
        VestingEventDto vestingEventDto = VestingEventMapper.INSTANCE.vestingEventToVestingEventDto(sellingEvent.getVestingEvent());
        return rsuService.getTaxationInformationAboutSelling(vestingEventDto, sellingEventDto, taxationType);
    }
}
