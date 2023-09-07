package com.credibanco.conseCar.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehiculos")
@Data
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_matricula")
    private Long id;

    @Column(name = "tipoVehiculo")
    private String tipo;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "anofabricacion")
    private int anoFabricacion;

    @Column(name = "precionuevo")
    private double precioNuevo;

    @Column(name = "preciousado")
    private double precioUsado;

    @ManyToOne
    @JoinColumn(name = "id_concesionario")
    private Consecionario consecionario;

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoFabricacion=" + anoFabricacion +
                ", precioNuevo=" + precioNuevo +
                ", precioUsado=" + precioUsado +
                '}';
    }
}
