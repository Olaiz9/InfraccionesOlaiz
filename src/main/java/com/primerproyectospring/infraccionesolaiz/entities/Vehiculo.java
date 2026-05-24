package com.primerproyectospring.infraccionesolaiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "vehiculo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Vehiculo extends Base {

    @Column(name = "color")
    private String color;

    @Column(name = "dominio")
    private String dominio;

    @Column(name = "anio_patentamiento")
    private Integer anioPatentamiento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_marca_fk")
    private Marca marcaAuto;
}
