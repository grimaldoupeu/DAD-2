package com.example.mscatalogo.service.impl;

import com.example.mscatalogo.entity.Product;
import com.example.mscatalogo.repository.ProductRepository;
import com.example.mscatalogo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listar() {
        return productRepository.findAll();
    }

    @Override
    public Product guardar(Product Product) {
        return productRepository.save(Product);
    }

    @Override
    public Optional<Product> buscarPorId(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product editar(Product Product) {
        return productRepository.save(Product);
    }

    @Override
    public void eliminar(Integer id) {
        productRepository.deleteById(id);
    }
}