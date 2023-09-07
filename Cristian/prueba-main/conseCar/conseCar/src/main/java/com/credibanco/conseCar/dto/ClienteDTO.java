package com.credibanco.conseCar.dto;

import lombok.Data;

@Data
public class ClienteDTO {

    private  Long id;

    private String nombre;

    private  String apellido;

    private int telefonoPersonal;

    private String direccion;


    @Override
    public String toString() {
        return "ClienteDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefonoPersonal=" + telefonoPersonal +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
