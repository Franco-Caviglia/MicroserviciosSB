package com.clientes.abonados.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Abonados")
@Builder
public class Abonado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_abonado;

    @Column(name = "num_cuenta")
    private Long numCuenta;//Numero distintivo de cuenta;
    private String nombreTitular;

    @Column(name = "apellido_titular")
    private String apellidoTitular;

    private String email;//Email titular para comunicacion;

    private String telefono;//telefono titular para comunicacion;

    private Long dni;
    @Column(name = "empresa_telefonica")
    private String empresaTelefonica;//Personal, movistar, etc;
    @Column(name = "num_tarjeta")
    private Long numTarjeta;

    private String domicilio;
    private String localidad;
    @Column(name = "tipo_pago")
    private String tipoPago;
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;//Comercio o residencia;
    private String comunicador;//Modelo del comunicador;
    private String comodato;//Valores "si", "no", "ok";
    @Column(name = "click_app")
    private String clickApp;//Si contiene o no la app;
    @Column(name = "ntlink_serie")
    private Long ntLinkSerie;//Codigo ntLink
    @Column(name = "linea_alarma")
    private String lineaAlarma;//Numero telefono u opcion "fijo";
    @Column(name = "cod_instalador")
    private Long codInstalador;//Codigo;
    @Column(name = "modelo_alarma")
    private String modeloAlarma;
    private String cobrador;//Cobrador asignado al abonado;
    private String abonado;//Nombre del local, comercio o nombre completo del titular;

    @OneToOne(targetEntity = Contrato.class)
    private Contrato contrato;
   @Override
    public String toString(){
       return "Abonado {" +
               "id_abonado=" + id_abonado +
               ", numCuenta=" + numCuenta +
               ", nombreTitular=" + nombreTitular +
               ", apellidoTitular=" + apellidoTitular +
               ", email=" + email +
               ", telefono=" + telefono +
               "dni=" + dni +
               "empresaTelefonica=" + empresaTelefonica +
               "numTarjeta=" + numTarjeta +
               "domicilio=" + domicilio +
               "localidad=" +  localidad +
               "tipoPago=" + tipoPago +
               "tipoCuenta=" + tipoCuenta +
               "comunicador=" + comunicador +
               "comodato=" + comodato +
               "clickApp=" + clickApp +
               "ntLinkSerie=" + ntLinkSerie +
               "lineaAlarma=" + lineaAlarma +
               "codInstalador=" + codInstalador +
               "modeloAlarma=" + modeloAlarma +
               "cobrador=" + cobrador +
               "abonado=" + abonado + "}";
   }
}
