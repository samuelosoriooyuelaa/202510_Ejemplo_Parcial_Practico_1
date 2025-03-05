package co.edu.uniandes.dse.parcialprueba.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.repositories.ConsultaMedicaRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import co.edu.uniandes.dse.parcialprueba.entities.ConsultaMedicaEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
@Slf4j
@Service
public class ConsultaMedicaService {

    @Autowired
    ConsultaMedicaRepository consultaMedicaRepository;

    @Transactional
    public ConsultaMedicaEntity crearConsultaMedica(ConsultaMedicaEntity consulta) throws IllegalOperationException{
        log.info("inicia creacion consulta");

        if (!consulta.getFecha().after(24:40-24:44)){

            throw new IllegalOperationException("la fecha es del pasado");

        }
        return consultaMedicaRepository.save(consulta);

    }



}
