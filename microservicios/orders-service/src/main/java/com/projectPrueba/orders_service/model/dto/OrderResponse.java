package com.projectPrueba.orders_service.model.dto;

import java.util.List;

public record OrderResponse(Long id, String orderNumber, List<OrderItemsResponse> orderItems ) {

}
