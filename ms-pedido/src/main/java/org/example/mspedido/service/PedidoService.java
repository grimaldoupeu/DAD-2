package org.example.mspedido.service;

import org.example.mspedido.entity.Pedido;

import java.util.List;

public interface PedidoService {
    public List<Pedido> listar();

    public Pedido guardar(Pedido Category);

    public Pedido buscarPorId(Integer id);

    public Pedido editar(Pedido Category);

    public void eliminar(Integer id);

}
