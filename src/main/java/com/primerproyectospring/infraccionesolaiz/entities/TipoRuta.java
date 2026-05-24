package com.primerproyectospring.infraccionesolaiz.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "tipo_ruta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class TipoRuta extends Base {

    @Column(name="desc_tipo_ruta")
    private String descTipoRuta;

    @Column(name = "nombre_tipo_ruta")
    private String nombreTipoDeRuta;
}