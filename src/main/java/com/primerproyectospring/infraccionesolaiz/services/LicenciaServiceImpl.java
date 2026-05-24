package com.primerproyectospring.infraccionesolaiz.services;

import com.primerproyectospring.infraccionesolaiz.entities.Licencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.primerproyectospring.infraccionesolaiz.repositories.BaseRepository;
import com.primerproyectospring.infraccionesolaiz.repositories.LicenciaRepository;

@Service
public class LicenciaServiceImpl extends BaseServiceImpl<Licencia, Long> implements LicenciaService {

    @Autowired
    private LicenciaRepository licenciaRepository;

    public LicenciaServiceImpl(BaseRepository<Licencia, Long> baseRepository) {
        super(baseRepository);
    }
}
