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
@Table(name = "autoridad_constatacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class AutoridadDeConstatacion extends Persona {

    @Column(name = "id_placa")
    private Integer idPlaca;

    @Column(name = "id_legajo")
    private Integer idLegajo;
}