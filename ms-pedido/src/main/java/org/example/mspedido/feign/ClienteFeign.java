package org.example.mspedido.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.mspedido.dto.Cliente;
import org.example.mspedido.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-cliente-service", path = "/cliente")
public interface ClienteFeign {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "clientListByIdCB", fallbackMethod = "clientListById")

    public ResponseEntity<Cliente> getById(@PathVariable Integer id);

    default ResponseEntity<Cliente> clientListById(Integer id, Exception e) {
        return ResponseEntity.ok(new Cliente());
    }
}
