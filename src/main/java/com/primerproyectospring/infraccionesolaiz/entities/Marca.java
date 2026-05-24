package com.primerproyectospring.infraccionesolaiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "marca")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Marca extends Base {

    @Column(name = "marca_auto")
    private String marcaAuto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_modelo_fk")
    private Modelo modeloAuto;
}
