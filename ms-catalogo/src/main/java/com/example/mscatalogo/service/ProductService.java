package com.example.mscatalogo.service;

import com.example.mscatalogo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> listar();

    public Product guardar(Product Product);

    public Optional<Product> buscarPorId(Integer id);

    public Product editar(Product Product);

    public void eliminar(Integer id);

}
