package com.primerproyectospring.infraccionesolaiz.services;

import com.primerproyectospring.infraccionesolaiz.entities.Infraccion;
import com.primerproyectospring.infraccionesolaiz.repositories.BaseRepository;
import com.primerproyectospring.infraccionesolaiz.repositories.InfraccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfraccionServiceImpl extends BaseServiceImpl<Infraccion, Long> implements InfraccionService {
    @Autowired
    private InfraccionRepository repository;
    public InfraccionServiceImpl(BaseRepository<Infraccion, Long> baseRepository) {
        super(baseRepository);
    }
}