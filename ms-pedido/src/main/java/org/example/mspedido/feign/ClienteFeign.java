package org.example.mspedido.feign;

import org.example.mspedido.dto.Cliente;
import org.example.mspedido.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-cliente-service", path = "/cliente")
public interface ClienteFeign {

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> listarClienteDtoPorId(@PathVariable(required = true) Integer id);
}
