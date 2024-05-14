package com.fernandoschimidt.car.repository;

import com.fernandoschimidt.car.entity.Car;
import com.fernandoschimidt.car.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Car, Long> {

    List<Car> findByName(String name);

    @Query("FROM Car c WHERE c.year > :ano")
    List<Car> findAboveYear(int ano);

//    @Query("FROM Car c WHERE c.id_marca = :marca")
    List<Car> findByMarca(Marca marca);
}
