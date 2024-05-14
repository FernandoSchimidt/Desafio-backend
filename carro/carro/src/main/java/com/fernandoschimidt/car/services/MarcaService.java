package com.fernandoschimidt.car.services;

import com.fernandoschimidt.car.entity.Marca;
import com.fernandoschimidt.car.repository.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    private final MarcaRepository repository;

    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }

    public Marca findById(Long id) throws Exception {
        var marca = repository.findById(id)
                .orElseThrow(() -> new Exception("Marca não encontrada"));
        return marca;
    }

    public Marca save(Marca marca) {
        return repository.save(marca);
    }

    public List<Marca> findAll() {
        List<Marca> marcas = repository.findAll();
        return marcas;
    }

}
