package org.example.mscliente.service;

import org.example.mscliente.entity.Cliente;

import java.util.List;

public interface ClienteService {

    public Cliente guardarCliente(Cliente cliente);
    public List<Cliente> listarCliente();
    public Cliente buscarClientePorId(Integer id);
    public Cliente editarCliente(Cliente cliente);
    public void eliminarCliente(Integer id);
}
