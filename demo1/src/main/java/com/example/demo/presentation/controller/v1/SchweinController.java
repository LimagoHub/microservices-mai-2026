package com.example.demo.presentation.controller.v1;


import com.example.demo.domain.service.SchweineService;
import com.example.demo.persistence.SchweinEntity;
import com.example.demo.persistence.SchweinRepository;
import com.example.demo.presentation.dto.SchweinDto;
import com.example.demo.presentation.mapper.SchweinDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/schweine")
@RequiredArgsConstructor
public class SchweinController {

    private final SchweineService schweineService;
    private final SchweinDtoMapper mapper;



    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchweinDto> getById(@PathVariable  UUID id) {
        return ResponseEntity.of(schweineService.findById(id).map(mapper::convert));
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<SchweinDto>> findAll() {
        return ResponseEntity.ok(mapper.convert(schweineService.findAll()));
    }
}
