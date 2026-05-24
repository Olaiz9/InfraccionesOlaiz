package com.primerproyectospring.infraccionesolaiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name="conductor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Conductor extends Persona {

    @Column(name="domicilio")
    private String domicilio;

}
