package com.credibanco.conseCar.implemetacion;

import com.credibanco.conseCar.dto.ClienteDTO;
import com.credibanco.conseCar.service.IEmpleadoService;

import java.util.List;

public class EmpleadoImpl implements IEmpleadoService {
    @Override
    public List<ClienteDTO> encontrarTodos() {
        return null;
    }

    @Override
    public ClienteDTO encontrarporId(Long Id) {
        return null;
    }

    @Override
    public void actualizarCliente(ClienteDTO cliente) {

    }

    @Override
    public void crearCliente(ClienteDTO clienteDTO) {

    }

    @Override
    public void eliminarCliente(Long id) {

    }
}
