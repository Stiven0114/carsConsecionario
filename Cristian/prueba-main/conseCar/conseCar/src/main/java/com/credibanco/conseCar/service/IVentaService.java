package com.credibanco.conseCar.service;

import com.credibanco.conseCar.dto.ClienteDTO;
import com.credibanco.conseCar.dto.VentaDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IVentaService {

    List<VentaDTO> encontrarTodos(Double ventas);

    public VentaDTO encontrarporId(Double Id);

    void actualizarVenta(VentaDTO ventaDTO);

    void crearVenta(ClienteDTO clienteDTO);



    void eliminarVenta(Double id);
}
