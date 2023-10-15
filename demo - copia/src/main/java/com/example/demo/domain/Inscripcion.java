package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table (name = "Inscripcion")
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaDeInscripcion;

    @Enumerated(EnumType.STRING) //https://www.baeldung.com/jpa-persisting-enums-in-jpa
    private Estado estado;

    //*******RELACIONES*******
    @ManyToOne //Una inscripcion puede hacerse para un solo curso. Un curso puede estar en varias inscripciones.
    @JoinColumn (name = "curso_id")   //La clave primaria de la tabla Curso.
    private Curso curso;

    @ManyToOne // Una inscripción puede hacerla solo un estudiante. Un estudiante puede hacer varias inscripciones.
    @JoinColumn (name = "estudiante_id")
    private Estudiante estudiante;
}
