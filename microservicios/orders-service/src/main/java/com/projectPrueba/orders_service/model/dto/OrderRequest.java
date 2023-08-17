package com.projectPrueba.orders_service.model.dto;

import com.projectPrueba.orders_service.model.entities.OrderItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private List<OrderItemRequest> orderItems;


}
