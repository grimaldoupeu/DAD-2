package com.example.mscatalogo.controller;

import com.example.mscatalogo.entity.Product;
import com.example.mscatalogo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listar() {
        return ResponseEntity.ok(productService.listar());
    }

    @PostMapping
    public ResponseEntity<Product> guardar(@RequestBody Product Product) {
        return ResponseEntity.ok(productService.guardar(Product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> buscarPorId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(productService.buscarPorId(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> editar(@PathVariable(required = true) Integer id,
                                           @RequestBody Product Product) {
        Product.setId(id);
        return ResponseEntity.ok(productService.editar(Product));

    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id) {
        productService.eliminar(id);
        return "Eliminacion correcta";
    }

}