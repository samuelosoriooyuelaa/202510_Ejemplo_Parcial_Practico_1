package co.edu.uniandes.dse.parcialprueba.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
@Data
@Entity
public class ConsultaMedicaEntity extends BaseEntity {

    private Date fecha;
    private String causa;

    @PodamExclude
    @ManyToOne
    private PacienteEntity paciente; 

}
