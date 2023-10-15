package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "Estudiante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String email;

    private int dni;

    private LocalDate fechaDeNacimiento;

    @Transient
    private int edad;
    //private int edad = Period.between(fechaDeNacimiento,LocalDate.now()).getYears();

    public boolean esMayorEdad(){
        return edad>=18;
    }

}
