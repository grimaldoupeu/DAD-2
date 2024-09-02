package org.example.mscliente.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String email;
    private String telefono;
    private String direccion;
    private String calle;
    private String numero;
    private String complemento;
}
