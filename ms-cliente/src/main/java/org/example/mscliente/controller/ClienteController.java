package org.example.mscliente.controller;

import org.example.mscliente.entity.Cliente;
import org.example.mscliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> guardarClienteResponseEntity(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.guardarCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClienteResponseEntity(Cliente cliente) {
        return ResponseEntity.ok(clienteService.listarCliente());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorIdResponseEntity(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(clienteService.buscarClientePorId(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> editarClienteResponseEntity(@PathVariable(required = true) Integer id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return ResponseEntity.ok(clienteService.editarCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public String eliminarClienteResponseEntity(@PathVariable(required = true) Integer id) {
        clienteService.eliminarCliente(id);
        return "Eliminacion Correcta del Cliente";
    }
}
