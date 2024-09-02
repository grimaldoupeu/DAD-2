package org.example.mscliente.service.impl;

import org.example.mscliente.entity.Cliente;
import org.example.mscliente.repository.ClienteRepository;
import org.example.mscliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Integer id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public Cliente editarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}
