package com.clientes.abonados.model.dto;

import lombok.*;

import java.util.List;



public record ContratoResponse (Long id_contrato, String montoContrato, List<CategoriaContratoResponse> categoriaContratoList){



}
