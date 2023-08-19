package com.clientes.abonados.repositories;

import com.clientes.abonados.model.entities.Abonado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbonadoRepository extends JpaRepository<Abonado, Long> {
}
