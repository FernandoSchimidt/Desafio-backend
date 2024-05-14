package com.fernandoschimidt.car.controller;

import com.fernandoschimidt.car.entity.Categoria;
import com.fernandoschimidt.car.entity.Marca;
import com.fernandoschimidt.car.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        var newCategoria = service.save(categoria);
        return ResponseEntity.ok().body(newCategoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable(name = "id") Long id) throws Exception {
        var categoria = service.findById(id);
        return ResponseEntity.ok().body(categoria);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categorias = service.findAll();
        return ResponseEntity.ok().body(categorias);
    }
}
