package org.example.mspedido.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.mspedido.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-catalogo-service", path = "/product")
public interface ProductFeign {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "productListByIdCB", fallbackMethod = "productListById")
    public ResponseEntity<Product> getById(@PathVariable Integer id);
    default ResponseEntity<Product> productListById(Integer id, Exception e) {
        return ResponseEntity.ok(new Product());
    }
}
