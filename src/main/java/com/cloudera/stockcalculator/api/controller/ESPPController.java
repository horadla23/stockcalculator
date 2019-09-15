package com.cloudera.stockcalculator.api.controller;

import com.cloudera.stockcalculator.api.dto.PurchaseEventDto;
import com.cloudera.stockcalculator.api.dto.taxation.PurchaseTaxInformation;
import com.cloudera.stockcalculator.api.mapper.PurchaseEventMapper;
import com.cloudera.stockcalculator.service.ESPPService;
import com.cloudera.stockcalculator.service.TaxationType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller
@RequestMapping("/espp")
public class ESPPController {

    @Inject
    private ESPPService esppService;

    @PostMapping("/purchase")
    public PurchaseEventDto addPurchaseEvent(@RequestBody PurchaseEventDto purchaseEventDto) {
        return PurchaseEventMapper.INSTANCE.purchaseEventToPurchaseEventDto(null);
    }

    @GetMapping("/purchase/{id}")
    public @ResponseBody
    PurchaseEventDto getPurchaseEvent(@PathVariable("id") Long id) {
        return PurchaseEventMapper.INSTANCE.purchaseEventToPurchaseEventDto(null);
    }

    @GetMapping("/purchase/{id}/tax/{taxation}")
    public @ResponseBody
    PurchaseTaxInformation getPurchaseTaxInformation(@PathVariable("id") Long id, @PathVariable("taxation") TaxationType taxationType) {
        PurchaseEventDto purchaseEventDto = PurchaseEventMapper.INSTANCE.purchaseEventToPurchaseEventDto(null);
        return null;
    }
}
