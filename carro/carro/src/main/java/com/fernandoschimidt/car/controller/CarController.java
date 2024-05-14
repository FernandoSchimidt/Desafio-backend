package com.fernandoschimidt.car.controller;

import com.fernandoschimidt.car.dto.CarRequest;
import com.fernandoschimidt.car.entity.Car;
import com.fernandoschimidt.car.entity.Marca;
import com.fernandoschimidt.car.services.CarsService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarsService service;

    public CarController(CarsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Car> create(@RequestBody Car carro) {
        var newCar = service.save(carro);
        return ResponseEntity.ok().body(newCar);
    }

    @GetMapping("/marca")
    public ResponseEntity<List<Car>> findByMarca(@RequestParam("marca") Marca marca) {
        List<Car> cars = service.findByMarca(marca);
        return ResponseEntity.ok().body(cars);
    }

    @GetMapping
    public ResponseEntity<List<Car>> findAll() {
        List<Car> cars = service.findAll();
        return ResponseEntity.ok().body(cars);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> edit(@PathVariable(name = "id") Long id, @RequestBody CarRequest request) throws Exception {
        var car = service.update(request, id);
        return ResponseEntity.ok().body(car);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable(name = "id") Long id) throws Exception {
        var car = service.findById(id);
        return ResponseEntity.ok().body(car);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) throws Exception {
        service.delete(id);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Car>> findByname(@RequestParam String name) {
        List<Car> cars = service.findByName(name);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }


    @GetMapping("/year")
    public ResponseEntity<List<Car>> findAboveYear(@RequestParam Integer year) {
        List<Car> cars = service.findAboveYear(year);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}
