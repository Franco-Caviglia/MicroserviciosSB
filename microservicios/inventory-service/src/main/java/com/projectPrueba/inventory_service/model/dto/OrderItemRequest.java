package com.projectPrueba.inventory_service.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequest {
    private Long id_order_items;
    private String sku;
    private Double price;
    private Long quantity;
}
