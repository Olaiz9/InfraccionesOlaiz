package com.primerproyectospring.infraccionesolaiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.time.LocalDate;

@Entity
@Table(name="licencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Licencia extends Base {

    @Column(name = "numero_licencia")
    private Integer numeroLicencia;

    @Column(name = "fecha_vto")
    private LocalDate fechaDeVto;

    @OneToOne
    @JoinColumn(name="id_conductor_fk")
    private Conductor conductor;
}
