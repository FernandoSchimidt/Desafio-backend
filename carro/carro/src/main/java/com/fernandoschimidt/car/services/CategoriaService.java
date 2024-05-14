package com.fernandoschimidt.car.services;

import com.fernandoschimidt.car.entity.Categoria;
import com.fernandoschimidt.car.entity.Marca;
import com.fernandoschimidt.car.repository.CategoriaRepository;
import com.fernandoschimidt.car.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria findById(Long id) throws Exception {
        var categoria = repository.findById(id)
                .orElseThrow(() -> new Exception("Categoria não encontrada"));
        return categoria;
    }

    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    public List<Categoria> findAll() {
        List<Categoria> categorias = repository.findAll();
        return categorias;

    }
}
