package com.primerproyectospring.infraccionesolaiz.services;

import com.primerproyectospring.infraccionesolaiz.entities.TipoRuta;
import com.primerproyectospring.infraccionesolaiz.repositories.BaseRepository;
import com.primerproyectospring.infraccionesolaiz.repositories.TipoRutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoRutaServiceImpl extends BaseServiceImpl<TipoRuta, Long> implements TipoRutaService {
    @Autowired
    private TipoRutaRepository repository;
    public TipoRutaServiceImpl(BaseRepository<TipoRuta, Long> baseRepository) {
        super(baseRepository);
    }
}
