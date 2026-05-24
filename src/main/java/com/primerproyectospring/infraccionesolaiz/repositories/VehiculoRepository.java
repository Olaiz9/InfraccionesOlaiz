package com.primerproyectospring.infraccionesolaiz.repositories;

import com.primerproyectospring.infraccionesolaiz.entities.Vehiculo;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends BaseRepository<Vehiculo, Long> {
}
