package org.example.mspedido.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.example.mspedido.dto.Product;

@Entity
@Data
public class PedidoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double cantidad;
    private Double precio;
    private int productoId;

    @Transient
    private Product producto;

    public PedidoDetalle(){
        this.cantidad = (double) 0;
        this.precio = (double) 0;
    }
}
