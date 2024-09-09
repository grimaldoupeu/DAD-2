package com.example.mscatalogo.controller;

import com.example.mscatalogo.entity.Category;
import com.example.mscatalogo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listar() {
        return ResponseEntity.ok(categoryService.listar());
    }

    @PostMapping
    public ResponseEntity<Category> guardar(@RequestBody Category Category) {
        return ResponseEntity.ok(categoryService.guardar(Category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> buscarPorId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(categoryService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> editar(@PathVariable(required = true) Integer id,
                                            @RequestBody Category Category) {
        Category.setId(id);
        return ResponseEntity.ok(categoryService.editar(Category));

    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id) {
        categoryService.eliminar(id);
        return "Eliminacion correcta";
    }

}