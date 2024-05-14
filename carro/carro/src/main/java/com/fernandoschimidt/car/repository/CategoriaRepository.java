package com.fernandoschimidt.car.repository;

import com.fernandoschimidt.car.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
