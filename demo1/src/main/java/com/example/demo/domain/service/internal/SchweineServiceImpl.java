package com.example.demo.domain.service.internal;

import com.example.demo.domain.mapper.SchweinMapper;
import com.example.demo.domain.model.Schwein;
import com.example.demo.domain.service.AlreadyExistException;
import com.example.demo.domain.service.NotFoundException;
import com.example.demo.domain.service.SchweineService;
import com.example.demo.persistence.SchweinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.AlreadyBoundException;
import java.util.Optional;
import java.util.UUID;


@Service
@Transactional
@RequiredArgsConstructor
public class SchweineServiceImpl implements SchweineService {

    private final SchweinRepository schweinRepository;
    private final SchweinMapper schweinMapper;

    @Override
    public void speichern(final Schwein schwein) {
        if(schweinRepository.existsById(schwein.getId())) throw  new AlreadyExistException("Schwein exists!");
        schweinRepository.save(schweinMapper.convert(schwein));
    }

    @Override
    public void aendern(final Schwein schwein) {
        if(! schweinRepository.existsById(schwein.getId())) throw  new NotFoundException("Schwein does not exists!");
        schweinRepository.save(schweinMapper.convert(schwein));
    }

    @Override
    public void loeschen(final UUID id) {
        if(! schweinRepository.existsById(id)) throw  new NotFoundException("Schwein  does not exists!");
        schweinRepository.deleteById(id);
    }

    @Override
    public Optional<Schwein> findById(final UUID id) {
        return schweinRepository.findById(id).map(schweinMapper::convert);
    }

    @Override
    public Iterable<Schwein> findAll() {
        return schweinMapper.convert(schweinRepository.findAll());
    }

    @Override
    public void fuettern(final UUID id) {
        Schwein schwein = findById(id).orElseThrow(()-> new NotFoundException("Schwein does not exists!"));
        schwein.fuettern();
        aendern(schwein);
    }
}
