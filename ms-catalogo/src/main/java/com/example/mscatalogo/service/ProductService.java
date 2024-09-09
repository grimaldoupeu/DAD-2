package com.example.mscatalogo.service;

import com.example.mscatalogo.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> listar();

    public Product guardar(Product Product);

    public Product buscarPorId(Integer id);

    public Product editar(Product Product);

    public void eliminar(Integer id);

}
