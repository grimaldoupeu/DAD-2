package org.example.mspedido.service.impl;

import org.example.mspedido.dto.Cliente;
import org.example.mspedido.dto.Product;
import org.example.mspedido.entity.Pedido;
import org.example.mspedido.entity.PedidoDetalle;
import org.example.mspedido.feign.ClienteFeign;
import org.example.mspedido.feign.ProductFeign;
import org.example.mspedido.repository.PedidoRepository;
import org.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteFeign clienteFeign;

    @Autowired
    private ProductFeign productoFeign;

    @Override
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido guardar(Pedido Category) {
        return pedidoRepository.save(Category);
    }

    @Override
    public Pedido buscarPorId(Integer id) {
        pedidoRepository.findById(id).get();
        Pedido pedido = pedidoRepository.findById(id).get();
        Cliente cliente = clienteFeign.clientListById(pedido.getClienteId()).getBody();
        List<PedidoDetalle> pedidoDetalles = pedido.getDetalle().stream().map(pedidoDetalle -> {
            Product producto = productoFeign.productListById(pedidoDetalle.getProductoId()).getBody();
            pedidoDetalle.setProducto(producto);
            return pedidoDetalle;
        }).collect(Collectors.toList());
        pedido.setDetalle(pedidoDetalles);
        pedido.setCliente(cliente);
        return pedido;
    }

    @Override
    public Pedido editar(Pedido Category) {
        return pedidoRepository.save(Category);
    }

    @Override
    public void eliminar(Integer id) {
        pedidoRepository.deleteById(id);
    }
}