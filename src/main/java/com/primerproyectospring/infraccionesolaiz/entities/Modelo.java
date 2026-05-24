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
@Table(name="modelo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Modelo extends Base {

    @Column(name="modelo_auto")
    private String modeloAuto;
}
