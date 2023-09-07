package com.credibanco.conseCar.controller;

import com.credibanco.conseCar.dto.ClienteDTO;
import com.credibanco.conseCar.negocio.ClienteNegocio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/consecionarios")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.HEAD})
public class ClienteController {

    private ClienteNegocio clienteNegocio;


    @GetMapping("/all") //Esta anotación indica que este método manejará las solicitudes GET en la ruta /consecionarios/all.
    @ResponseBody// Esta anotación indica que el valor devuelto por este método será escrito directamente en el cuerpo de la respuesta HTTP.
    public ResponseEntity<Map<String,Object>>all(){
//Esta es la firma del método. El método se llama all y no toma ningún parámetro.

    Map<String,Object> res = new HashMap<>();
// Esta línea crea un nuevo objeto HashMap para almacenar la respuesta que se enviará al cliente.

    List<ClienteDTO> clienteDTOList = this.clienteNegocio.encontrarTodos();
/** Esta línea llama al método encontrarTodos de la capa de negocio para buscar todos los clientes.
 *  El resultado se almacena en una variable clienteDTOList de tipo List<ClienteDTO>.
  */

    List<ClienteDTO> sortedList = clienteDTOList.stream().sorted(Comparator.comparing(ClienteDTO ::getId)).collect(Collectors.toList());
//Esta línea convierte la lista de clientes en un Stream para poder aplicar operaciones con funciones lambda.

    res.put("status","ok");
    res.put("data" , sortedList);

    return  new ResponseEntity<>(res, HttpStatus.OK);
    }
}
