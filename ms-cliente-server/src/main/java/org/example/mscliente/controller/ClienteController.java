package org.example.mscliente.controller;

import org.example.mscliente.entity.Cliente;
import org.example.mscliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    public ResponseEntity<Cliente> guardarClienteResponseEntity(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.guardarCliente(cliente));
    }

    public ResponseEntity<List<Cliente>> listarClienteResponseEntity(Cliente cliente) {
        return ResponseEntity.ok(clienteService.listarCliente());
    }

    public ResponseEntity<Cliente> buscarClientePorIdResponseEntity(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(clienteService.buscarClientePorId(id));
    }

    public ResponseEntity<Cliente> editarClienteResponseEntity(@PathVariable(required = true) Integer id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return ResponseEntity.ok(clienteService.editarCliente(cliente));
    }

    public String eliminarClienteResponseEntity(@PathVariable(required = true) Integer id) {
        clienteService.eliminarCliente(id);
        return "Eliminacion Correcta del Cliente";
    }
}
