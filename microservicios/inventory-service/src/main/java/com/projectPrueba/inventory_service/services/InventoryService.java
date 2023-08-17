package com.projectPrueba.inventory_service.services;

import com.projectPrueba.inventory_service.model.dto.BaseResponse;
import com.projectPrueba.inventory_service.model.dto.OrderItemRequest;
import com.projectPrueba.inventory_service.model.entities.Inventory;
import com.projectPrueba.inventory_service.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String sku){
        var inventory = inventoryRepository.findBySku(sku);

        return inventory.filter(value -> value.getQuantity()>0).isPresent();
    }

    public BaseResponse areInStock(List<OrderItemRequest> orderItems){
        var errorList = new ArrayList<String>();

        List<String> skus = orderItems.stream().map(OrderItemRequest::getSku).toList(); //Recupera todos los 'skus' y los retorna en una lista en forma de string;

        //Obtiene todos los registros en inventory con los skus que tenemos;
        List<Inventory> inventoryList = inventoryRepository.findBySkuIn(skus);

        //retorna todos los registros correspondientes a la sku que se encuentra en la tabla;
        orderItems.forEach(orderItem -> {
            var inventory = inventoryList.stream().filter(value -> value.getSku().equals(orderItem.getSku())).findFirst();
            if(inventory.isEmpty()){
                errorList.add("Product with sku " + orderItem.getSku() + " does not exist");
            } else if (inventory.get().getQuantity() < orderItem.getQuantity()){
                errorList.add("Product with sku " + orderItem.getSku() + " has insufficient quantity ");
            }
        });
        return !errorList.isEmpty() ? new BaseResponse(errorList.toArray(new String[0])) : new BaseResponse(null);
    }
}
