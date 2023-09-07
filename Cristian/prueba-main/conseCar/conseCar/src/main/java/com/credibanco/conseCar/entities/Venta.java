package com.credibanco.conseCar.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "venta_id")
    private Long id;

    @Column(name = "precioventa")
    private double precioVenta;

    @Column(name = "puntos")
    private int puntosAcumulados;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn (name = "empleado_id")
    private Empleado empleado;


    @Override
    public String toString() {
        return "Ventas{" +
                "precioVenta=" + precioVenta +
                ", puntosAcomulados=" + puntosAcumulados +
                '}';

    }
}
