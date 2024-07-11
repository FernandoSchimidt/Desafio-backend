package com.fernandoschimidt.magalusms.repository;

import com.fernandoschimidt.magalusms.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Long> {
}
