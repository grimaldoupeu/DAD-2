package org.example.mspedido.controller;

import org.example.mspedido.entity.Pedido;
import org.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

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