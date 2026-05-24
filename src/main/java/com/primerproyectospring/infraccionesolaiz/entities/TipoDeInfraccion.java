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
@Table(name = "tipo_de_infraccion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class TipoDeInfraccion extends Base {

    @Column(name = "descripcion")
    private String descripInfraccion;

    @Column(name = "tipo_gravedad")
    private String tipoGravedad;

    @Column(name="importe_asignado")
    private Double importeAsignadoInfraccion;

    @Column(name="porcentaje_descuento")
    private Double porcentajeDescuento;
}
