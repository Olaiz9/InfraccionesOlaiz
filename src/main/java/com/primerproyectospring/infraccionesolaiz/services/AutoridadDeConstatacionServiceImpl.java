package com.primerproyectospring.infraccionesolaiz.services;

import com.primerproyectospring.infraccionesolaiz.entities.AutoridadDeConstatacion;
import com.primerproyectospring.infraccionesolaiz.repositories.AutoridadDeConstatacionRepository;
import com.primerproyectospring.infraccionesolaiz.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoridadDeConstatacionServiceImpl extends BaseServiceImpl<AutoridadDeConstatacion, Long> implements AutoridadDeConstatacionService {
    @Autowired
    private AutoridadDeConstatacionRepository repository;
    public AutoridadDeConstatacionServiceImpl(BaseRepository<AutoridadDeConstatacion, Long> baseRepository) {
        super(baseRepository);
    }
}