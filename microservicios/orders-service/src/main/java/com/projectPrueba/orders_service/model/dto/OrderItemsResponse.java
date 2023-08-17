package com.projectPrueba.orders_service.model.dto;

import java.math.BigDecimal;

public record OrderItemsResponse(Long id, String sku, Double price, Long quantity) {

}
