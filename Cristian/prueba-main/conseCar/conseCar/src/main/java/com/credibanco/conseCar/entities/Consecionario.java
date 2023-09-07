package com.credibanco.conseCar.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "consecionario")
@Data
public class Consecionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "consecionario_id")
    private  Long id;

    @Column(name = "nombre")
    private  String nombre;

    @Column(name = "direccion")
    private String direccion;


    @OneToMany(mappedBy = "consecionario")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "consecionario")
    private List<Empleado> empleados;

    @Override
    public String toString() {
        return "Consecionario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
