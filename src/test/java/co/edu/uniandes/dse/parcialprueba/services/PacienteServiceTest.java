package co.edu.uniandes.dse.parcialprueba.services;


import jakarta.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.services.PacienteService;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import java.util.List;
import java.util.ArrayList;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(PacienteService.class)
public class PacienteServiceTest {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    private TestEntityManager entityManager;
    private PodamFactory factory = new PodamFactoryImpl();
    private List<PacienteEntity> pacienteList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        clearData();
        insertData();
    }

    private void clearData() {
        entityManager.getEntityManager().createQuery("delete from MedicoEntity").executeUpdate();
    }

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PacienteEntity pacienteEntity = factory.manufacturePojo(PacienteEntity.class);
            entityManager.persist(pacienteEntity);
            pacienteList.add(pacienteEntity);
        }
    }
    @Test
    void testCreatePaciente() throws IllegalOperationException {
        pacienteEntity newEntity = factory.manufacturePojo(pacienteEntity.class);
        PacienteEntity result = pacienteService.crearPaciente(newEntity);

        assertNotNull(result);

        PacienteEntity entity = entityManager.find(PacienteEntity.class, result.getId());

        assertEquals(newEntity.getId(), entity.getId());
        assertEquals(newEntity.getNombre(), entity.getNombre());
        assertEquals(newEntity.getApellido(), entity.getCorreo());
        assertEquals(newEntity.getRegistroMedico(), entity.getCelular());
    }

   


}
