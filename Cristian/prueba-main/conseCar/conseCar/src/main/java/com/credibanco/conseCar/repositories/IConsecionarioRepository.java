package com.credibanco.conseCar.repositories;

import com.credibanco.conseCar.entities.Consecionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsecionarioRepository extends JpaRepository<Consecionario, Long> {
}
