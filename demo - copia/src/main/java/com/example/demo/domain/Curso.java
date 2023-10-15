package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Locale;

@Entity
@Table(name = "Curso") //Al definir la clase Curso como tabla, todas sus propiedades las va a tomar como una columna
@AllArgsConstructor //Crea un constructor para todos los argumentos
// Con constructor se crea un Curso en DemoApplication de esta forma:
// Curso curso = new Curso(null, "SprinBoot", "Framework java backend",LocalDate.now(), LocalDate.of(2023,7,19));
// Si se usa Getter o Setter se crea como se creo Estudiante en DemoApplication.
@NoArgsConstructor  //Crea un constructor vacio
public class Curso  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre") //No es necesaria esta linea si el nombre de la columna a la que persiste es igual al nombre
                            //de la propiedad. Pero es una buena práctica hacerlo. Al usar @Table ya toma como columnas
                            //todas las propiedades.
    private String nombre;

    private String descripcion;

    private LocalDate fechaDeInicio;

    private LocalDate fechaDeFin;

}
