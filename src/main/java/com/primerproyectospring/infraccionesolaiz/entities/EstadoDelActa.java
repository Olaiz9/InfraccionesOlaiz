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
@Table(name = "estado_del_acta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class EstadoDelActa extends Base {

    @Column(name = "descripcion_estado")
    private String descripcionEstadoActa;

    @Column(name = "nombre_estado")
    private String nombreEstadoActa;
}
