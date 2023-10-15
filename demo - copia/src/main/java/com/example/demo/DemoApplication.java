package com.example.demo;

import com.example.demo.domain.Curso;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Estudiante;
import com.example.demo.domain.Inscripcion;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.InscripcionRepository;
import com.example.demo.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired //Sirve para inyectar dependencias, en este caso nuestra dependencia es el repository
	EstudianteRepository estudianteRepository;

	@Autowired
	CursoRepository cursoRepository;

	@Autowired
	InscripcionRepository inscripcionRepository;

	@Autowired
	InscripcionService inscripcionService;

	private void saveEstuduantes(){
		estudianteRepository.saveAll(Arrays.asList(
				new Estudiante(null,"Pablo","Magallan","emailmagallan@gmail.com",32111111,LocalDate.of(1987,5,6),36),
				new Estudiante(null,"Mariano","Razetto","emailrazetto@gmail.com",32222222,LocalDate.of(1990,3,21),35),
				new Estudiante(null,"Luis","Macias","emailmacias@gmail.com",32333333,LocalDate.of(1989,10,28),28),
				new Estudiante(null,"Carlos","Lucero","emaillucero@gmail.com",32444444,LocalDate.of(1988,5,12),25),
				new Estudiante(null,"Ivan","Salomoni","emailsalomoni@gmail.com",321555555,LocalDate.of(1986,8,20),45)
		));
	}

	private void saveCursos(){
		cursoRepository.saveAll(Arrays.asList(
				new Curso(null, "SpringBoot", "Spring Framework java",LocalDate.now(), LocalDate.of(2023,12,31)),
				new Curso(null, "Frontend", "HTML y CSS",LocalDate.now(), LocalDate.of(2023,12,31)),
				new Curso(null, "SQL", "Bases de datos relacionales",LocalDate.now(), LocalDate.of(2023,12,31))
		));
	}


	//Se ejecutan antes del inicio de la aplicación
	//Se hace para testear que este funcionando el repository haciendo un save y luego recuperando los datos
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {
			saveEstuduantes();
			saveCursos();

			inscripcionService.insc(1L, 1L);

			//Prueba 1 - Conexion a base de datos - Clase 4
			/*
			estudianteRepository.findAll(); //Aqui no debería recuperar nada
			//Para guardar estos datos en el repository usamos:
			estudianteRepository.save(estudiante);

			System.out.println("La aplicacion se ha iniciado");

			estudianteRepository.findAll(); //Aqui si debería recuperarlo porque ya se hizo el save

			//Prueba 2 - Creacion de inscripcion con estudiante y curso - Clase 5 (repaso de modelado)

			//crear un estdiante (Creado en Prueba 1 con setter)
			//crear un curso (Con constructor)
			//crear con el estudiante y el curso una inscripcion (Con constructor)

			Curso curso = new Curso(null, "SpringBoot", "Framework java backend",LocalDate.now(), LocalDate.of(2023,7,19));
			cursoRepository.save(curso);

			estudiante = estudianteRepository.findById(1L).get(); //Clase 5 min 5 esta explicado por que hace esto.
			curso = cursoRepository.findById(1L).get();

			Inscripcion inscripcion = new Inscripcion(null, LocalDate.now(), Estado.ACEPTADA, curso, estudiante);
			inscripcionRepository.save(inscripcion);
			*/
		};
	}
}
