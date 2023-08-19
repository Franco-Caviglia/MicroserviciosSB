package com.projectPrueba.products_service.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;
    private String sku; //Codigo del producto;
    private String name; //Nombre del producto;
    private String description;
    private String status;
    private Double price;

    @Override
    public String toString(){
        return "Product{" +
                "id=" + id_product +
                ", name='" + name + "'" +
                ", description='" + description + "'" +
                "}";
    }
}
