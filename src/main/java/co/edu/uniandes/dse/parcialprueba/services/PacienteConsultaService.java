package co.edu.uniandes.dse.parcialprueba.services;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uniandes.dse.parcialprueba.repositories.ConsultaMedicaRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import co.edu.uniandes.dse.parcialprueba.entities.ConsultaMedicaEntity;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import java.util.Optional;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class PacienteConsultaService {

     @Autowired
     private ConsultaMedicaRepository consultaMedicaRepository;
     @Autowired
     private PacienteRepository pacienteRepository;

     @Transactional
    public ConsultaMedicaEntity addConsulta(Long idPaciente,Long idConsulta)throws EntityNotFoundException{
        log.info("agregando especialidad");
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(idPaciente);
        Optional<ConsultaMedicaEntity> consultaMedicaEntity = consultaMedicaRepository.findById(idConsulta);
        if (pacienteEntity.isEmpty()){
            throw new EntityNotFoundException("no existe el paciente");

        }
        if (consultaMedicaEntity.isEmpty()){
            throw new EntityNotFoundException("consulta invalida");
        }

        consultaMedicaEntity.get().setPaciente(pacienteEntity.get());
        return consultaMedicaEntity.get();
        
        

        
    

    }


    @Transactional
	public List<ConsultaMedicaEntity> getConsultas(Long pacienteId) throws EntityNotFoundException {
		log.info("Inicia proceso de consultar los citas asociadas al paciente con id = {0}", pacienteId);
		Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(pacienteId);
		if(pacienteEntity.isEmpty())
			throw new EntityNotFoundException("no se encuentra el paciente");
		
		return pacienteEntity.get().getCitas();
	}



}
