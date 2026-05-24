package com.primerproyectospring.infraccionesolaiz.services;

import com.primerproyectospring.infraccionesolaiz.entities.Ruta;
import com.primerproyectospring.infraccionesolaiz.repositories.BaseRepository;
import com.primerproyectospring.infraccionesolaiz.repositories.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutaServiceImpl extends BaseServiceImpl<Ruta, Long> implements RutaService {
    @Autowired
    private RutaRepository repository;
    public RutaServiceImpl(BaseRepository<Ruta, Long> baseRepository) {
        super(baseRepository);
    }
}
