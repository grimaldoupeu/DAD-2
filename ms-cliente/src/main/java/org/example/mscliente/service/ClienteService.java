package org.example.mscliente.service;

import org.example.mscliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    public Cliente guardarCliente(Cliente cliente);
    public List<Cliente> listarCliente();
    public Optional<Cliente> buscarClientePorId(Integer id);
    public Cliente editarCliente(Cliente cliente);
    public void eliminarCliente(Integer id);
}
