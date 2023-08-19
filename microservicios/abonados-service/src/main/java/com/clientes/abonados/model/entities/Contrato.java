package com.clientes.abonados.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Contratos")
@Builder
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contrato;
    @Column(name = "monto_contrato")
    private String montoContrato;//Monto total;

    @OneToMany(mappedBy = "contrato")
    private List<CategoriaContrato> categoriaContratoList;

}
