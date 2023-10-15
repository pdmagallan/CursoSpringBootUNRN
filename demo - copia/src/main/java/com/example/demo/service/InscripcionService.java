package com.example.demo.service;

import com.example.demo.domain.Curso;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Estudiante;
import com.example.demo.domain.Inscripcion;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.InscripcionRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
@Validated
public class InscripcionService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Transactional
    public void insc(@NotNull @Positive Long estudianteId, @NotNull @Positive Long cursoId){

        Estudiante estudiante = estudianteRepository
                .findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("El id del estudiante no es válido"));

        int edad = Period.between(estudiante.getFechaDeNacimiento(),LocalDate.now()).getYears();
        estudiante.setEdad(edad);
                //Period.between(fechaDeNacimiento,LocalDate.now()).getYears();

        if (!estudiante.esMayorEdad()) {
            throw new RuntimeException("El estudiante es menor de edad...");
        }

        Curso curso = cursoRepository
                .findById(cursoId)
                .orElseThrow(() -> new RuntimeException("El id del curso no es válido"));

        LocalDate fechaDeINscripcion = LocalDate.now();
        Estado estado = Estado.PENDIENTE;

        Inscripcion inscripcion = new Inscripcion(
                null,
                fechaDeINscripcion,
                estado,
                curso,
                estudiante
        );

        inscripcionRepository.save(inscripcion);

    }
}
