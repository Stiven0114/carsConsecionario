package com.credibanco.conseCar.service;

import com.credibanco.conseCar.dto.EmpleadoDTO;
import com.credibanco.conseCar.dto.VehiculoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IConsecionarioService {

    List<EmpleadoDTO> encontrarTodosEmpleados();



    List<VehiculoDTO> encontrarTodosVehiculos();

    public EmpleadoDTO encontrarporId(Long Id);

    void actualizarEmpelado(EmpleadoDTO empleadoDTO);

    void crearEmpleado(EmpleadoDTO empleadoDTO);

    void eliminarEmpleado(Long id);


}
