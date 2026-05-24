package com.primerproyectospring.infraccionesolaiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "acta_de_constatacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class ActaDeConstatacion extends Base {

    @Column(name = "fecha_labrado")
    private LocalDate fechaDeLabrado;

    @Column(name = "fecha_vto_pago_voluntario")
    private LocalDate fechaVtoPagoVolun;

    @Column(name = "hora_labrado")
    private LocalTime horaDeLabrado;

    @Column(name = "lugar_constatacion")
    private String lugarDeConstatacion;

    @Column(name = "observaciones", length = 500)
    private String observaciones;

    @OneToMany(mappedBy = "acta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Infraccion> mInfraccion = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="id_organizacion_fk")
    private OrganizacionEstatal organizacionEstatal;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo_fk")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "id_estado_acta_fk")
    private EstadoDelActa estadoDelActa;

    @ManyToOne
    @JoinColumn(name = "id_autoridad_fk")
    private AutoridadDeConstatacion autoridadDeConstatacion;

    @ManyToOne
    @JoinColumn(name="id_licencia_fk")
    private Licencia licencias;

    @ManyToOne
    @JoinColumn(name="id_ruta_fk")
    private Ruta ruta;
}
