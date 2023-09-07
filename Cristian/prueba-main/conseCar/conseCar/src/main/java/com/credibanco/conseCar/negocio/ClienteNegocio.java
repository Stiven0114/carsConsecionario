package com.credibanco.conseCar.negocio;

import com.credibanco.conseCar.dto.ClienteDTO;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ClienteNegocio {
    public List<ClienteDTO> encontrarTodos() {
        // Utilizamos el método encontrarTodos para obtener una lista de objetos ClienteDTO
        List<ClienteDTO> clienteDTOs = encontrarTodos();

        // Devolvemos la lista de objetos ClienteDTO
        return clienteDTOs;
    }



}
