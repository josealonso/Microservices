package com.josealonso.inventoryservice.controller;

import com.josealonso.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping(name = "/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/sku-code")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku_code") String skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}
