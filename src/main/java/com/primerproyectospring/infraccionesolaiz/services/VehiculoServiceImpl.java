package com.primerproyectospring.infraccionesolaiz.services;

import com.primerproyectospring.infraccionesolaiz.entities.Vehiculo;
import com.primerproyectospring.infraccionesolaiz.repositories.BaseRepository;
import com.primerproyectospring.infraccionesolaiz.repositories.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoServiceImpl extends BaseServiceImpl<Vehiculo, Long> implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(BaseRepository<Vehiculo, Long> baseRepository) {
        super(baseRepository);
    }
}
