package com.credibanco.conseCar.implemetacion;


import com.credibanco.conseCar.dto.EmpleadoDTO;
import com.credibanco.conseCar.dto.VehiculoDTO;
import com.credibanco.conseCar.entities.Empleado;
import com.credibanco.conseCar.entities.Vehiculo;
import com.credibanco.conseCar.repositories.IEmpleadoRepository;
import com.credibanco.conseCar.repositories.IVehiculoRepository;
import com.credibanco.conseCar.service.IConsecionarioService;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


public class ConsecionarioImpl implements IConsecionarioService {

    private final IEmpleadoRepository iEmpleadoRepository;

    private final IVehiculoRepository iVehiculoRepository;

    public ConsecionarioImpl(IEmpleadoRepository iEmpleadoRepository, IVehiculoRepository iVehiculoRepository) {
        this.iEmpleadoRepository = iEmpleadoRepository;
        this.iVehiculoRepository = iVehiculoRepository;
    }


    @Override
    public List<EmpleadoDTO> encontrarTodosEmpleados() {

        List<Empleado> empleados = iEmpleadoRepository.findAll();
        if (empleados.isEmpty()) {
            throw new EntityNotFoundException("No se encontro el empleado");
        }

        List<EmpleadoDTO> empleadoDTOList = empleados.stream().map(empleado -> mapToDto(empleado)).collect(Collectors.toList());
        return null;
    }

    @Override
    public List<VehiculoDTO> encontrarTodosVehiculos() {

        List<Vehiculo> vehiculos = iVehiculoRepository.findAll();
        if (vehiculos.isEmpty()) {
            throw new EntityNotFoundException("Nose econtro el vehiculo ");
        }

        //  List<VehiculoDTO> vehiculoDTOSList = vehiculos.stream().map(vehiculo -> mapToDtoVehiculo(vehiculo)).collect(Collectors.toList());
        return null;
    }

    @Override
    public EmpleadoDTO encontrarporId(Long Id) {
        return null;
    }

    @Override
    public void actualizarEmpelado(EmpleadoDTO empleadoDTO) {

    }

    @Override
    public void crearEmpleado(EmpleadoDTO empleadoDTO) {

    }

    @Override
    public void eliminarEmpleado(Long id) {

    }

    private EmpleadoDTO mapToDto(Empleado empleado) {
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();

        empleadoDTO.setId(empleado.getId());
        empleadoDTO.setNombre(empleado.getNombre());
        empleadoDTO.setApellido(empleado.getApellido());
        empleadoDTO.setCorreoCorporativo(empleado.getCorreoCorporativo());
        return empleadoDTO;
    }
}
/**
    private VehiculoDTO mapToDtoVehiculo(Vehiculo vehiculo){
        VehiculoDTO vehiculoDTO = new VehiculoDTO();

        vehiculoDTO.setId(vehiculo.getId());
        VehiculoDTO.setNombre(empleado.getNombre());
        VehiculoDTO.setApellido(empleado.getApellido());
        VehiculoDTO.setCorreoCorporativo(empleado.getCorreoCorporativo());
        return vehiculoDTO;
}
**/