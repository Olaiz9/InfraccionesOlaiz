package com.primerproyectospring.infraccionesolaiz.services;

import com.primerproyectospring.infraccionesolaiz.entities.ActaDeConstatacion;
import com.primerproyectospring.infraccionesolaiz.repositories.ActaDeConstatacionRepository;
import com.primerproyectospring.infraccionesolaiz.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActaDeConstatacionServiceImpl extends BaseServiceImpl<ActaDeConstatacion, Long> implements ActaDeConstatacionService {
    @Autowired
    private ActaDeConstatacionRepository repository;
    public ActaDeConstatacionServiceImpl(BaseRepository<ActaDeConstatacion, Long> baseRepository) {
        super(baseRepository);
    }
}
