package com.example.demo.persistence;

import jakarta.persistence.Entity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SchweinRepository extends CrudRepository<SchweinEntity, UUID> {

    Iterable<SchweinEntity> findByName(String name);
}

