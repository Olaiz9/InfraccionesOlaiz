package com.primerproyectospring.infraccionesolaiz.services;

import com.primerproyectospring.infraccionesolaiz.entities.Modelo;
import com.primerproyectospring.infraccionesolaiz.repositories.BaseRepository;
import com.primerproyectospring.infraccionesolaiz.repositories.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloServiceImpl extends BaseServiceImpl<Modelo, Long> implements ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public ModeloServiceImpl(BaseRepository<Modelo, Long> baseRepository) {
        super(baseRepository);
    }
}