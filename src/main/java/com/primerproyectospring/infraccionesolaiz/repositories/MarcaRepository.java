package com.primerproyectospring.infraccionesolaiz.repositories;

import com.primerproyectospring.infraccionesolaiz.entities.Marca;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends BaseRepository<Marca, Long> {
}
