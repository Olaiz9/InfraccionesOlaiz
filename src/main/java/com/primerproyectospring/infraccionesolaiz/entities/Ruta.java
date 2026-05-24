package com.primerproyectospring.infraccionesolaiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "ruta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Ruta extends Base {

    @Column(name = "nombre_ruta")
    private String nombreRuta;

    @Column(name="km_ruta")
    private String kmRuta;

    @ManyToOne
    @JoinColumn(name = "id_tipo_ruta_fk")
    private TipoRuta tipoRuta;
}