package com.credibanco.conseCar.controller;

import com.credibanco.conseCar.dto.VentaDTO;
import com.credibanco.conseCar.implemetacion.ClientImpl;
import com.credibanco.conseCar.negocio.ClientNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/clientes")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.HEAD})
public class ClientController {


    @Autowired
    private ClientNegocio clientNegocio;

    @GetMapping("allVentas")
    public ResponseEntity<List<VentaDTO>> obtenerTodasLasVentas() {
        List<VentaDTO> ventas = clientNegocio.encontrarTodasVentas();
        return ResponseEntity.ok(ventas);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarVenta(@PathVariable Long id, @RequestBody VentaDTO ventaDTO) {
        try {
            ventaDTO.setId(ventaDTO.getId());
            List<VentaDTO> ventasActualizadas = clientNegocio.actualizarVentas(ventaDTO);
            return ResponseEntity.ok(ventasActualizadas);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}



