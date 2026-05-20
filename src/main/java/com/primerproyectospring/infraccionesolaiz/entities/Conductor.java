package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
