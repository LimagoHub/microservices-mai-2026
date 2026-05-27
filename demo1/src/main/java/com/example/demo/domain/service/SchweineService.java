package com.example.demo.domain.service;

import com.example.demo.domain.model.Schwein;

import java.util.Optional;
import java.util.UUID;

public interface SchweineService {

    void speichern(Schwein schwein);
    void aendern(Schwein schwein);
    void loeschen (UUID id);
    Optional<Schwein> findById(UUID id);
    Iterable<Schwein> findAll();
    void fuettern(UUID id);
}
