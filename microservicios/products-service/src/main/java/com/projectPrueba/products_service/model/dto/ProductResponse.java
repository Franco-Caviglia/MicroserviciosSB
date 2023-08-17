package com.projectPrueba.products_service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private Long   id_product;
    private String sku;
    private String name;
    private String description;
    private String status;
    private Double price;
}
