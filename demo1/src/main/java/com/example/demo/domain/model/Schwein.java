package com.example.demo.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter(AccessLevel.PRIVATE)
public class Schwein {


    private UUID id;


    private String name;

    private int gewicht;

    public void fuettern() {
        setGewicht(getGewicht() + 1);
    }
}
