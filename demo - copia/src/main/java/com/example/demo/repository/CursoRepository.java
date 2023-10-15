package com.example.demo.repository;

import com.example.demo.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CursoRepository extends JpaRepository <Curso, Long> {

    //Listar todos los cursos
    @Query("SELECT c FROM Curso c")
    List<Curso> findAllCursos();

    //Listar todos los cursos mediante consulta derivada


    //Listar todos los cursos que hayan empezado después de “01/02/2020”
    @Query("SELECT c FROM Curso c WHERE c.fechaDeInicio > TO_DATE('01/02/2020','dd/mm/YYYY')")
    List<Curso> findByFechaDeInicioNoNativa(LocalDate fechaDeInicio);

    //Listar todos los cursos que hayan empezado después de “01/02/2020” mediante consulta derivada
    List<Curso> findByfechaDeInicio(LocalDate fechaDeInicio);


}
