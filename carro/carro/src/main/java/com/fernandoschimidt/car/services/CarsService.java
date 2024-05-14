package com.fernandoschimidt.car.services;

import com.fernandoschimidt.car.dto.CarRequest;
import com.fernandoschimidt.car.entity.Car;
import com.fernandoschimidt.car.entity.Marca;
import com.fernandoschimidt.car.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {

    private final CarroRepository repository;

    public CarsService(CarroRepository repository) {
        this.repository = repository;
    }

    public Car save(Car carro) {
        return repository.save(carro);
    }

    public Car update(CarRequest carro, Long id) throws Exception {
        var oldCarro = repository.findById(id)
                .orElseThrow(() -> new Exception("Carro não econtrado"));
        oldCarro.setName(carro.name());
        oldCarro.setYear(carro.year());
        oldCarro.setColor(carro.color());

        return repository.save(oldCarro);
    }

    public List<Car> findAll() {
        List<Car> carros = repository.findAll();
        return carros;
    }

    public Car findById(Long id) throws Exception {
        var carro = repository.findById(id)
                .orElseThrow(() -> new Exception("Carro não encontrado"));
        return carro;
    }

    public void delete(Long id) throws Exception {
        var carro = repository.findById(id)
                .orElseThrow(() -> new Exception("Carro não encontrado"));
        repository.deleteById(id);
    }

    public List<Car> findByName(String name) {
        return repository.findByName(name);

    }
    public List<Car> findByMarca(Marca marca){
        return repository.findByMarca(marca);
    }



    public List<Car> findAboveYear(Integer id) {
        return repository.findAboveYear(id);
    }
}
