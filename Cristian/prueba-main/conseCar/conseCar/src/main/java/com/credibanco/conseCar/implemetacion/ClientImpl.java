package com.credibanco.conseCar.implemetacion;

import com.credibanco.conseCar.dto.VentaDTO;
import com.credibanco.conseCar.entities.Venta;
import com.credibanco.conseCar.repositories.IVentaRepository;
import com.credibanco.conseCar.service.IClientService;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ClientImpl implements IClientService {

    private final IVentaRepository iVentaRepository;

    public ClientImpl(IVentaRepository iVentaRepository) {
        this.iVentaRepository = iVentaRepository;
    }


    @Override
    public List<VentaDTO> encontrarTodasVentas() {

        List<Venta> ventaList = iVentaRepository.findAll();

        if (ventaList.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron clientes");
        }

        List<VentaDTO> ventaDTOS = ventaList.stream()
                .map(venta -> mapToDto(venta))
                .collect(Collectors.toList());

        return ventaDTOS;
    }

    @Override
    public List<VentaDTO> actualizarVentas(VentaDTO ventaDTO) {
        Optional<Venta> ventaOptional = iVentaRepository.findById(ventaDTO.getId());

        if (ventaOptional.isPresent()) {
            Venta venta = ventaOptional.get();


            int puntosActuales = venta.getPuntosAcumulados();
            int puntosGanados = 2;


            if (puntosActuales + puntosGanados >= 50) {

                double descuento = venta.getPrecioVenta() * 0.5;
                venta.setPrecioVenta(venta.getPrecioVenta() - descuento);
                puntosGanados = 0;
            }

            venta.setPuntosAcumulados(puntosActuales + puntosGanados);

            iVentaRepository.save(venta);

            List<Venta> ventasClientList = iVentaRepository.findByCliente(venta.getCliente());

            return ventasClientList.stream().map(this::mapToDto).collect(Collectors.toList());

        }else {
            throw new EntityNotFoundException("no se encontro una venta con el ID especificado");
        }

    }




    private VentaDTO mapToDto(Venta venta){
        VentaDTO ventaDTO = new VentaDTO();

        ventaDTO.setId(venta.getId());
        ventaDTO.setPrecioVenta(venta.getPrecioVenta());
        ventaDTO.setPuntosAcomulados(venta.getPuntosAcumulados());
        return ventaDTO;
    }

}
