package com.credibanco.conseCar.service;

import com.credibanco.conseCar.dto.VentaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClientService {

    List<VentaDTO>encontrarTodasVentas();

    List<VentaDTO> actualizarVentas(VentaDTO ventaDTO);

}
