package com.primerproyectospring.infraccionesolaiz.repositories;

import com.primerproyectospring.infraccionesolaiz.entities.TipoDeInfraccion;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeInfraccionRepository extends BaseRepository<TipoDeInfraccion, Long> {
}