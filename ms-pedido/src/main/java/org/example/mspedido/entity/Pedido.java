package org.example.mspedido.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.example.mspedido.dto.Cliente;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serie;
    private String numero;
    private String descripcion;
    private int clienteId;
    @JsonIgnoreProperties({"hibirnateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private List<PedidoDetalle> detalle;

    @Transient
    private Cliente cliente;

}