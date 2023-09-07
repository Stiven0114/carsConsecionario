package com.credibanco.conseCar.repositories;

import com.credibanco.conseCar.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado,Long> {
}
