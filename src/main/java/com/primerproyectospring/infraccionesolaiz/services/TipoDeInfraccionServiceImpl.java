package com.primerproyectospring.infraccionesolaiz.services;

import com.primerproyectospring.infraccionesolaiz.entities.TipoDeInfraccion;
import com.primerproyectospring.infraccionesolaiz.repositories.BaseRepository;
import com.primerproyectospring.infraccionesolaiz.repositories.TipoDeInfraccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDeInfraccionServiceImpl extends BaseServiceImpl<TipoDeInfraccion, Long> implements TipoDeInfraccionService {
    @Autowired
    private TipoDeInfraccionRepository repository;
    public TipoDeInfraccionServiceImpl(BaseRepository<TipoDeInfraccion, Long> baseRepository) {
        super(baseRepository);
    }
}
