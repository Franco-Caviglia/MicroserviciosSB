package com.projectPrueba.orders_service.services;

import com.projectPrueba.orders_service.model.dto.*;
import com.projectPrueba.orders_service.model.entities.Order;
import com.projectPrueba.orders_service.model.entities.OrderItems;
import com.projectPrueba.orders_service.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final WebClient.Builder webClientBuilder;
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){

        //Check for inventory;
        BaseResponse result = this.webClientBuilder.build()
                .post()
                .uri("http://localhost:8083/api/inventory/in-stock")
                .bodyValue(orderRequest.getOrderItems())
                .retrieve()
                .bodyToMono(BaseResponse.class)
                .block();
        if(result != null && !result.hasErrors()){
            Order order = new Order();
            order.setOrderNumber((UUID.randomUUID().toString()));

            order.setOrderItems(orderRequest.getOrderItems().stream()
                    .map(orderItemRequest -> mapOrderItemRequestToOrderItem(orderItemRequest, order))
                    .toList());

            this.orderRepository.save(order);

        }else {
            throw new IllegalArgumentException("Some of the products are not in stock");
        }


    }
    public List<OrderResponse> getAllOrders(){
        List<Order> orders = this.orderRepository.findAll();

        return orders.stream().map(this::mapToOrderResponse).toList();
    }

    private OrderResponse mapToOrderResponse(Order order) {
        return new OrderResponse(order.getId_order(), order.getOrderNumber()
                        , order.getOrderItems().stream().map(this::mapToOrderItemRequest).toList());

        
    }

    private OrderItemsResponse mapToOrderItemRequest(OrderItems orderItems) {
        return new OrderItemsResponse(orderItems.getId_order_items(), orderItems.getSku(),
                orderItems.getPrice(), orderItems.getQuantity());
    }

    private OrderItems mapOrderItemRequestToOrderItem(OrderItemRequest orderItemRequest, Order order) {
        return OrderItems.builder()
                .id_order_items(orderItemRequest.getId_order_items())
                .sku(orderItemRequest.getSku())
                .price(orderItemRequest.getPrice())
                .quantity(orderItemRequest.getQuantity())
                .order(order)
                .build();
    }

}
