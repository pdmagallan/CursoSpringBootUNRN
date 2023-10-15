package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CursoDTO {

    private String nombre;
    private String descripcion;
    private LocalDate fechaDeInicio;
    private LocalDate fechaDeFin;

}
