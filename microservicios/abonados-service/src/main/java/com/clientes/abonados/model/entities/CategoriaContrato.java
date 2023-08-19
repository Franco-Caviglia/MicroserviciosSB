package com.clientes.abonados.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Tipos de servicios que proporcionara la empresa;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Categorias")
@Builder
public class CategoriaContrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria_contrato;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;
    @Column(name = "monto_categoria")
    private Double montoCategoria;

    @ManyToOne
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;

}
