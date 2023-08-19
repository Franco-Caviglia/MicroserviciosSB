package com.clientes.abonados.model.dto;

import com.clientes.abonados.model.entities.Contrato;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AbonadoRequest {

    private Long numCuenta;
    private String nombreTitular;
    private String apellidoTitular;
    private String email;
    private String telefono;
    private Long dni;
    private String empresaTelefonica;
    private Long numTarjeta;
    private String domicilio;
    private String localidad;
    private String tipoPago;
    private String tipoCuenta;
    private String comunicador;
    private String comodato;
    private String clickApp;
    private Long ntLinkSerie;
    private String lineaAlarma;
    private Long codInstalador;
    private String modeloAlarma;
    private String cobrador;
    private String abonado;
    private Contrato contrato;
}
