package com.clientes.abonados.controller;

import com.clientes.abonados.model.dto.AbonadoRequest;
import com.clientes.abonados.model.dto.AbonadoResponse;
import com.clientes.abonados.model.dto.ContratoRequest;
import com.clientes.abonados.services.AbonadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class AbonadoController {

    private final AbonadoService abonadoService;

    @PostMapping("/addClient")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAbonado(@RequestBody AbonadoRequest abonadoRequest){
        this.abonadoService.addAbonado(abonadoRequest);
        this.abonadoService.addContrato(abonadoRequest, new ContratoRequest());
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<AbonadoResponse> getAllAbonados(){
        return this.abonadoService.getAllAbonados();
    }
}
