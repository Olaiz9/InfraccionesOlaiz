package com.primerproyectospring.infraccionesolaiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.List;

@Entity
@Table(name = "infraccion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Infraccion extends Base {

    @Column(name = "descrip_infraccion")
    private String descripInfraccion;

    @Column(name="importe_infraccion")
    private Double importeInfraccion;

    @ManyToOne
    @JoinColumn(name = "id_acta_fk")
    private ActaDeConstatacion acta;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "infraccion_x_tipo",
            joinColumns = @JoinColumn(name = "id_infraccion_fk"),
            inverseJoinColumns = @JoinColumn(name = "id_tipo_infraccion_fk"))
    private List<TipoDeInfraccion> infraccionNomenclada;
}
