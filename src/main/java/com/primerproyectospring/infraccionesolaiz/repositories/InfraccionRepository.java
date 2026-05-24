package com.primerproyectospring.infraccionesolaiz.repositories;

import com.primerproyectospring.infraccionesolaiz.entities.Infraccion;
import org.springframework.stereotype.Repository;

@Repository
public interface InfraccionRepository extends BaseRepository<Infraccion, Long> {

}
