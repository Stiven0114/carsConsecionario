package com.credibanco.conseCar.implemetacion;


import com.credibanco.conseCar.dto.ClienteDTO;
import com.credibanco.conseCar.entities.Cliente;
import com.credibanco.conseCar.entities.Venta;
import com.credibanco.conseCar.repositories.IClienteRepository;
import com.credibanco.conseCar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
public class ClienteImpl implements IClienteService {

   private final   IClienteRepository iClienteRepository;
    @Autowired
    public ClienteImpl(IClienteRepository iClienteRepository) {
        this.iClienteRepository = iClienteRepository;
    }


    @Override
    public List<ClienteDTO> encontrarTodos() {
        // Utilizamos el método findAll del repositorio para obtener una lista de clientes
        List<Venta> clientes = iClienteRepository.findAll();

        // Verificamos si la lista de clientes está vacía
        if (clientes.isEmpty()) {
            // Si la lista está vacía, lanzamos una excepción
            throw new EntityNotFoundException("No se encontraron clientes");
        }

        // Utilizamos una expresión lambda para convertir cada objeto Cliente en un objeto ClienteDTO
        List<ClienteDTO> clienteDTOs = clientes.stream()
                .map(cliente -> mapToDto(cliente))
                .collect(Collectors.toList());

        // Devolvemos la lista de objetos ClienteDTO
        return clienteDTOs;
    }



    @Override
    public ClienteDTO encontrarporId(Long id) {
        // Utilizamos el método findById del repositorio para buscar el cliente por su ID
         Optional<Cliente> cliente = iClienteRepository.findById(id);

        // Utilizamos el método orElseThrow para lanzar una excepción si el cliente no se encuentra
        Cliente clienteEncontrado = cliente.orElseThrow(()-> new EntityNotFoundException("Cliente no encontrado"));


        // Utilizamos el método mapToDto para convertir el objeto Cliente en un objeto ClienteDTO
        ClienteDTO clienteDTO= mapToDto(clienteEncontrado);

        return clienteDTO;

    }

    @Override
    public void actualizarCliente(ClienteDTO clienteDTO) {
        // Utilizamos el método findById del repositorio para buscar el cliente por su ID
        Optional<Cliente> clienteExistente = iClienteRepository.findById(clienteDTO.getId());

        // Utilizamos el método ifPresentOrElse para actualizar el cliente si existe o lanzar una excepción si no existe
        clienteExistente.ifPresentOrElse(
                  c ->{
                      // Mapeamos los valores del DTO al cliente existente
                      c.setNombre(clienteDTO.getNombre());
                      c.setApellido(clienteDTO.getApellido());
                      c.setDireccion(clienteDTO.getDireccion());
                      c.setTelefonoPersonal(clienteDTO.getTelefonoPersonal());
                      c.setId(clienteDTO.getId());

                      // Guardamos los cambios en el repositorio
                      iClienteRepository.save(c);
                  },()-> {
                    throw new EntityNotFoundException("Cliente no encontrado ");
                }
        );

    }

    @Override
    public void crearCliente(ClienteDTO clienteDTO) {
        // Utilizamos el método mapToEntity para convertir el objeto ClienteDTO en un objeto Cliente
        Cliente cliente = mapToEntity(clienteDTO);

        // Utilizamos el método save del repositorio para guardar el objeto Cliente en la base de datos
        iClienteRepository.save(cliente);

    }

    @Override
    public void eliminarCliente(Long id) {
        // Utilizamos el método deleteById del repositorio
        iClienteRepository.deleteById(id);
    }

    private ClienteDTO mapToDto(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId(cliente.getId());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setTelefonoPersonal(cliente.getTelefonoPersonal());
        clienteDTO.setDireccion(cliente.getDireccion());
        return clienteDTO;
        }

    private Cliente mapToEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();

        cliente.setId(clienteDTO.getId());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setTelefonoPersonal(clienteDTO.getTelefonoPersonal());
        cliente.setDireccion(clienteDTO.getDireccion());

        return cliente;
    }


}

**/