package com.clientes.abonados.services;

import com.clientes.abonados.model.dto.CategoriaContratoRequest;
import com.clientes.abonados.model.dto.CategoriaContratoResponse;
import com.clientes.abonados.model.dto.ContratoResponse;
import com.clientes.abonados.model.entities.CategoriaContrato;
import com.clientes.abonados.model.entities.Contrato;
import com.clientes.abonados.repositories.ContratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratoService {

    private final ContratoRepository contratoRepository;


    public List<ContratoResponse> getAllContratos(){
        List<Contrato> contrato = this.contratoRepository.findAll();
        return contrato.stream().map(this::mapToContratoResponse).toList();
    }

    private ContratoResponse mapToContratoResponse(Contrato contrato) {
        return new ContratoResponse(contrato.getId_contrato(), contrato.getMontoContrato(),
                contrato.getCategoriaContratoList().stream().map(this::mapToCategoriaContratoRequest).toList());

    }

    private CategoriaContratoResponse mapToCategoriaContratoRequest(CategoriaContrato categoriaContrato) {
        return new CategoriaContratoResponse(categoriaContrato.getId_categoria_contrato(), categoriaContrato.getNombreCategoria(),
                categoriaContrato.getMontoCategoria());
    };
}
