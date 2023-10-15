package com.example.demo.repository;

import com.example.demo.domain.Curso;
import com.example.demo.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteRepository extends JpaRepository <Estudiante, Long>{

    //Listar todos los estudiantes
    @Query("SELECT c FROM Estudiante c")
    List<Estudiante> findAllEstudiantes();

    //Listar todos los estudiantes que tengan un dni mayor a 20M y que su apellido sea “Romero”
    @Query("SELECT c FROM Estudiante c WHERE c.dni > 20000000 AND c.apellido = 'Romero'")
    List<Estudiante> findByDniAndApellidoNoNativa();

    //Listar todos los estudiantes que tengan un dni mayor a 20M y que su apellido sea “Romero” con consulta derivada
    List<Estudiante> findByDniAndApellido(int dni, String apellido);

    //Listar todos los estudiantes de forma paginada y ordenada ascendente por DNI

    //Crear BreakPoint despues de saveEstuduantes(); en DemoApplication y evaluar las siguientes expresiones.
    //Pagina 1, tamaño 5
    //estudianteRepository.findAll(PageRequest.of(1,5,Sort.by(Sort.Direction.ASC, "dni")))
    //Pagina 0, tamaño 2
    //estudianteRepository.findAll(PageRequest.of(0,2,Sort.by(Sort.Direction.ASC, "dni")))

}
