package com.credibanco.conseCar.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class VehiculoDTO {

    private Long id;

    private String tipo;

    private String modelo;

    private int anoFabricacion;

    private double precioNuevo;

    private double precioUsado;
}
