package com.clientes.abonados.model.dto;

import com.clientes.abonados.model.entities.CategoriaContrato;
import com.clientes.abonados.model.entities.Contrato;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaContratoRequest {

    private Long id_categoria_contrato;
    private String nombreCategoria;
    private Double montoCategoria;

}
