package com.credibanco.conseCar.repositories;

import com.credibanco.conseCar.entities.Cliente;
import com.credibanco.conseCar.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IClienteRepository extends JpaRepository<Venta, Long> {
}
