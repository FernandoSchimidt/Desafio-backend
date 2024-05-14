package com.fernandoschimidt.car.controller;

import com.fernandoschimidt.car.entity.Marca;
import com.fernandoschimidt.car.services.MarcaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {
    private final MarcaService service;

    public MarcaController(MarcaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Marca> create(@RequestBody Marca marca) {
        var newMarca = service.save(marca);
        return ResponseEntity.ok().body(newMarca);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> findById(@PathVariable(name = "id") Long id) throws Exception {
        var marca = service.findById(id);
        return ResponseEntity.ok().body(marca);
    }

    @GetMapping
    public ResponseEntity<List<Marca>> findAll() {
        List<Marca> marcas = service.findAll();
        return ResponseEntity.ok().body(marcas);
    }
}
