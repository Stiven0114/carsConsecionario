package com.credibanco.conseCar.repositories;

import com.credibanco.conseCar.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
}
