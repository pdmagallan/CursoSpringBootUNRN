package com.example.demo.repository;

import com.example.demo.domain.Estado;
import com.example.demo.domain.Inscripcion;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Past;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscripcionRepository extends JpaRepository <Inscripcion, Long>{


    //Listar todas las inscripciones rechazadas o pendientes
    @Query("SELECT c FROM Inscripcion c WHERE c.estado = 'RECHAZADA' OR c.estado = 'PENDIENTE'")
    List<Inscripcion> findByEstado();

    //Listar todas las inscripciones en base a un parámetro de estado
    @Query("SELECT c FROM Inscripcion c WHERE c.estado = :estado")
    List<Inscripcion> findByParametroEstado(@Param("estado")Estado estado);

    List<Inscripcion> findByEstado(Estado estado);

    //Listar todas las inscripciones en base a un parámetro de estado utilizando consulta nativa
    @Query(value="SELECT * FROM Inscripcion c WHERE c.estado = :estado", nativeQuery = true)
    List<Inscripcion> findByParametroEstadoNat(@Param("estado")Estado estado);

}
