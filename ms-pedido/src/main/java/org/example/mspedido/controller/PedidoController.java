package org.example.mspedido.controller;

import org.example.mspedido.dto.Cliente;
import org.example.mspedido.dto.ErrorResponseDto;
import org.example.mspedido.dto.Product;
import org.example.mspedido.entity.Pedido;
import org.example.mspedido.entity.PedidoDetalle;
import org.example.mspedido.feign.ClienteFeign;
import org.example.mspedido.feign.ProductFeign;
import org.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ClienteFeign clienteFeign;
    @Autowired
    private ProductFeign productFeign;


    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        return ResponseEntity.ok(pedidoService.listar());
    }

    @PostMapping
    public ResponseEntity<Pedido> guardar(@RequestBody Pedido Pedido) {
        return ResponseEntity.ok(pedidoService.guardar(Pedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pedido pedido){
       Cliente cliente = clienteFeign.getById(pedido.getClienteId()).getBody();

        if (cliente == null || cliente.getId() == null) {
            String errorMessage = "Error: Cliente no encontrado.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(errorMessage));
        }
        for (PedidoDetalle pedidoDetalle : pedido.getDetalle()) {
            Product product = productFeign.getById(pedidoDetalle.getProductoId()).getBody();

            if (product == null || product.getId() == null) {
                String errorMessage = "Error: producto no encontrado.";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(errorMessage));
            }
        }
        Pedido newOrder = pedidoService.guardar(pedido);
        return ResponseEntity.ok(newOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> editar(@PathVariable(required = true) Integer id,
                                                                       @RequestBody Pedido Pedido) {
        Pedido.setId(id);
        return ResponseEntity.ok(pedidoService.editar(Pedido));

    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id) {
        pedidoService.eliminar(id);
        return "Eliminacion correcta";
    }

}