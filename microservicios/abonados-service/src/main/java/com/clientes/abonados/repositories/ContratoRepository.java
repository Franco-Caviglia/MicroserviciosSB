package com.clientes.abonados.repositories;

import com.clientes.abonados.model.entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

}
