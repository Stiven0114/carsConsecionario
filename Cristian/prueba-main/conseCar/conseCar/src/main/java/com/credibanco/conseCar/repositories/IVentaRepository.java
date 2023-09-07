package com.credibanco.conseCar.repositories;

import com.credibanco.conseCar.dto.VentaDTO;
import com.credibanco.conseCar.entities.Cliente;
import com.credibanco.conseCar.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVentaRepository extends JpaRepository<Venta , Long> {

    public List<Venta>findByCliente(Cliente cliente);
}
