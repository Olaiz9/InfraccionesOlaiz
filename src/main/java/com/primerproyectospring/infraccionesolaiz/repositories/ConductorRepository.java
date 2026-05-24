package com.primerproyectospring.infraccionesolaiz.repositories;

import com.primerproyectospring.infraccionesolaiz.entities.Conductor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends BaseRepository<Conductor, Long> {
}
