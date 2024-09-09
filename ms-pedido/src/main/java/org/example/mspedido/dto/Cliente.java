package org.example.mspedido.dto;

import lombok.Data;

@Data
public class Cliente {

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
