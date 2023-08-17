package com.projectPrueba.inventory_service.controllers;


import com.projectPrueba.inventory_service.model.dto.BaseResponse;
import com.projectPrueba.inventory_service.model.dto.OrderItemRequest;
import com.projectPrueba.inventory_service.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;


    @GetMapping("/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku") String sku){
        return inventoryService.isInStock(sku);
    }

    @PostMapping("/in-stock")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse areInStock(@RequestBody List<OrderItemRequest> orderItems){
        return inventoryService.areInStock(orderItems);
    }
}
