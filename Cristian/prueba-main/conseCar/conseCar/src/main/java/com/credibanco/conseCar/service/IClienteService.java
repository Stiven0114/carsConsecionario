package com.credibanco.conseCar.service;

import com.credibanco.conseCar.dto.ClienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IClienteService   {
    List<ClienteDTO> encontrarTodos();

    public ClienteDTO encontrarporId(Long Id);

    void actualizarCliente(ClienteDTO cliente);

    void crearCliente(ClienteDTO clienteDTO);

    void eliminarCliente(Long id);
}
