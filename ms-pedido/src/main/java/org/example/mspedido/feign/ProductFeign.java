package org.example.mspedido.feign;

import org.example.mspedido.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-catalogo-service", path = "/product")
public interface ProductFeign {

    @GetMapping("/{id}")
    public ResponseEntity<Product> listarProductoDtoPorId(@PathVariable(required = true) Integer id);
}
