package com.credibanco.conseCar.implemetacion;

import com.credibanco.conseCar.dto.ClienteDTO;
import com.credibanco.conseCar.dto.VentaDTO;
import com.credibanco.conseCar.service.IVentaService;

import java.util.List;

public class VehiculoImpl implements IVentaService {
    @Override
    public List<VentaDTO> encontrarTodos(Double ventas) {
        return null;
    }

    @Override
    public VentaDTO encontrarporId(Double Id) {
        return null;
    }

    @Override
    public void actualizarVenta(VentaDTO ventaDTO) {

    }

    @Override
    public void crearVenta(ClienteDTO clienteDTO) {

    }

    @Override
    public void eliminarVenta(Double id) {

    }
}
