package com.primerproyectospring.infraccionesolaiz.services;

import com.primerproyectospring.infraccionesolaiz.entities.EstadoDelActa;
import com.primerproyectospring.infraccionesolaiz.repositories.BaseRepository;
import com.primerproyectospring.infraccionesolaiz.repositories.EstadoDelActaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoDelActaServiceImpl extends BaseServiceImpl<EstadoDelActa, Long> implements EstadoDelActaService {
    @Autowired
    private EstadoDelActaRepository repository;
    public EstadoDelActaServiceImpl(BaseRepository<EstadoDelActa, Long> baseRepository) {
        super(baseRepository);
    }
}
