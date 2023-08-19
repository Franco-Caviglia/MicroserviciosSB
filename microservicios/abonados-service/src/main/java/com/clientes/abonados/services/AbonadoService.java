package com.clientes.abonados.services;

import com.clientes.abonados.model.dto.*;
import com.clientes.abonados.model.entities.Abonado;
import com.clientes.abonados.model.entities.CategoriaContrato;
import com.clientes.abonados.model.entities.Contrato;
import com.clientes.abonados.repositories.AbonadoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AbonadoService {

    private final AbonadoRepository abonadoRepository;
    public void addAbonado(AbonadoRequest abonadoRequest){
        var client = Abonado.builder()
                .numCuenta(abonadoRequest.getNumCuenta())
                .nombreTitular(abonadoRequest.getNombreTitular())
                .apellidoTitular(abonadoRequest.getApellidoTitular())
                .email(abonadoRequest.getEmail())
                .telefono(abonadoRequest.getTelefono())
                .dni(abonadoRequest.getDni())
                .empresaTelefonica(abonadoRequest.getEmpresaTelefonica())
                .numTarjeta(abonadoRequest.getNumTarjeta())
                .domicilio(abonadoRequest.getDomicilio())
                .localidad(abonadoRequest.getLocalidad())
                .tipoPago(abonadoRequest.getTipoPago())
                .tipoCuenta(abonadoRequest.getTipoCuenta())
                .comunicador(abonadoRequest.getComunicador())
                .comodato(abonadoRequest.getComodato())
                .clickApp(abonadoRequest.getClickApp())
                .ntLinkSerie(abonadoRequest.getNtLinkSerie())
                .lineaAlarma(abonadoRequest.getLineaAlarma())
                .codInstalador(abonadoRequest.getCodInstalador())
                .modeloAlarma(abonadoRequest.getModeloAlarma())
                .cobrador(abonadoRequest.getCobrador())
                .abonado(abonadoRequest.getAbonado())
                .contrato(abonadoRequest.getContrato())
                .build();
        abonadoRepository.save(client);

        log.info("Client added: {}", client);
    }

    public void addContrato(AbonadoRequest abonadoRequest, ContratoRequest contratoRequest){
        Contrato contrato = new Contrato();
        contrato.setCategoriaContratoList(contratoRequest.getCategoriaContrato().stream()
                .map(categoriaContratoRequest -> mapCategoriaContratoRequestToCategoriaContrato(categoriaContratoRequest, contrato))
                .toList());
        abonadoRequest.setContrato(contrato);
    }

    public CategoriaContratoResponse mapToCategoriaContratoResponse(CategoriaContrato categoriaContrato){
        return new CategoriaContratoResponse(categoriaContrato.getId_categoria_contrato(),
                categoriaContrato.getNombreCategoria(), categoriaContrato.getMontoCategoria());
    }

    private CategoriaContrato mapCategoriaContratoRequestToCategoriaContrato(CategoriaContratoRequest categoriaContratoRequest, Contrato contrato){
        return CategoriaContrato.builder()
                .id_categoria_contrato(categoriaContratoRequest.getId_categoria_contrato())
                .nombreCategoria(categoriaContratoRequest.getNombreCategoria())
                .montoCategoria(categoriaContratoRequest.getMontoCategoria())
                .contrato(contrato)
                .build();
    }
    public List<AbonadoResponse> getAllAbonados(){
        var clients = abonadoRepository.findAll();

        return clients.stream().map(this::mapToAbonadoResponse).toList();
    }

    private AbonadoResponse mapToAbonadoResponse(Abonado abonado){
        return AbonadoResponse.builder()
                .id_abonado(abonado.getId_abonado())
                .numCuenta(abonado.getNumCuenta())
                .nombreTitular(abonado.getNombreTitular())
                .apellidoTitular(abonado.getApellidoTitular())
                .email(abonado.getEmail())
                .telefono(abonado.getTelefono())
                .dni(abonado.getDni())
                .empresaTelefonica(abonado.getEmpresaTelefonica())
                .numTarjeta(abonado.getNumTarjeta())
                .domicilio(abonado.getDomicilio())
                .localidad(abonado.getLocalidad())
                .tipoPago(abonado.getTipoPago())
                .tipoCuenta(abonado.getTipoCuenta())
                .comunicador(abonado.getComunicador())
                .comodato(abonado.getComodato())
                .clickApp(abonado.getClickApp())
                .ntLinkSerie(abonado.getNtLinkSerie())
                .lineaAlarma(abonado.getLineaAlarma())
                .codInstalador(abonado.getCodInstalador())
                .modeloAlarma(abonado.getModeloAlarma())
                .cobrador(abonado.getCobrador())
                .abonado(abonado.getAbonado())
                .contrato(abonado.getContrato())
                .build();
    }
}

