package com.credibanco.conseCar.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idcliente")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telPersonal")
    private int telefonoPersonal;

    @ManyToMany
    @JoinColumn(name = "consecionario_id")
    private List<Cliente> clientes;

    @ManyToMany
    @JoinColumn(name = "id_matricula")
    private List<Vehiculo> vehiculos;


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefonoPersonal=" + telefonoPersonal +
                '}';
    }
}
