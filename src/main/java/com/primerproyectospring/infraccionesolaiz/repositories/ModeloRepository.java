package com.primerproyectospring.infraccionesolaiz.repositories;

import com.primerproyectospring.infraccionesolaiz.entities.Modelo;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends BaseRepository<Modelo, Long> {
}