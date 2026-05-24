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
@Table(name = "organizacion_estatal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class OrganizacionEstatal extends Base {

    @Column(name = "nombre_organizacion")
    private String nombreOrganizacion;

    @Column(name = "localidad")
    private String localidad;
}
