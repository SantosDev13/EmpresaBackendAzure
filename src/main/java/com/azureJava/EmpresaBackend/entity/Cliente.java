package com.azureJava.EmpresaBackend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity //Convierte a la clase en una Entidad pesistente (tabla de una base de datos)
@Table(name= "clientes") // Le asigna un nombre dentro de la base de datos
public class Cliente {

    @Id //Declaramos como clave primaria
    @GeneratedValue (strategy = GenerationType.IDENTITY ) //Generamos identificador unico autormatica 1,2,3,4,5,etc
    private Long id;

    @NotBlank //Validacion para no permitir campos vacios
    @Column(nullable = false, length = 120)
    private String nombre;

    @Email //Validacion para formato email
    @NotBlank
    @Column(nullable = false, length = 150)
    private String email;

    public Cliente(){} //Constructor vacio se usa para poder instanciar la clase sin necesidad de sus parametros

    public Cliente(Long id, String nombre, String email){
        this.id= id;
        this.nombre= nombre;
        this.email= email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
