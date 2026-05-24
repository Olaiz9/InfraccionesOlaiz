package com.primerproyectospring.infraccionesolaiz.services;

import com.primerproyectospring.infraccionesolaiz.entities.Conductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.primerproyectospring.infraccionesolaiz.repositories.BaseRepository;
import com.primerproyectospring.infraccionesolaiz.repositories.ConductorRepository;

@Service
public class ConductorServiceImpl extends BaseServiceImpl<Conductor, Long> implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    public ConductorServiceImpl(BaseRepository<Conductor, Long> baseRepository) {
        super(baseRepository);
    }
}
