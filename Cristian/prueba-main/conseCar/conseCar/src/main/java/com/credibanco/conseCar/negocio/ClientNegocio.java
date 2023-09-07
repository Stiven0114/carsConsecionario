package com.credibanco.conseCar.negocio;
import com.credibanco.conseCar.dto.VentaDTO;
import com.credibanco.conseCar.implemetacion.ClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;
@Component
public class ClientNegocio {

    private final  ClientImpl clientImpl;
    @Autowired
    public ClientNegocio(ClientImpl clientImpl) {
        this.clientImpl = clientImpl;
    }

    public List<VentaDTO>encontrarTodasVentas(){
        return clientImpl.encontrarTodasVentas();
    }


    public List<VentaDTO> actualizarVentas(VentaDTO ventaDTO) {
       return clientImpl.actualizarVentas(ventaDTO);
    }



}

