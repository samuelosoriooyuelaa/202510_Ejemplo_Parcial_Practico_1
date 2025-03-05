package co.edu.uniandes.dse.parcialprueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.uniandes.dse.parcialprueba.entities.ConsultaMedicaEntity;
import java.util.List;
import java.util.ArrayList;


@Repository
public interface ConsultaMedicaRepository extends JpaRepository < ConsultaMedicaEntity,Long>{
    List<ConsultaMedicaEntity> findByCausa(String causa);


}
