package org.example.mspedido.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {

    private Integer id;
    private String nombre;
    private String descripcion;
    private String nivel;
    private String code;
    private String estado;
    private LocalDateTime fecha_creacion;
    private LocalDateTime fecha_modificacion;


    @PrePersist
    public void onCreate(){
        fecha_creacion = java.time.LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate(){
        fecha_modificacion = java.time.LocalDateTime.now();
    }

}
