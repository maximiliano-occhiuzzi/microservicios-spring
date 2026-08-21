package com.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AlumnoAltaDTO;
import com.app.model.Alumno;
import com.app.service.AlumnoService;

@RestController
@RequestMapping("/alumnos")

public class AlumnoController {

	private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }
    @PostMapping
    public ResponseEntity<Alumno> altaAlumno(@RequestBody AlumnoAltaDTO dto) {
        Alumno nuevo = new Alumno();
        nuevo.setNombre(dto.nombre());
        nuevo.setApellido(dto.apellido());
        nuevo.setDni(dto.dni());
        nuevo.setEmail(dto.email());

        Alumno creado = alumnoService.altaAlumno(nuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
     // este DTO la agrego por una cuestion que en el momento de usar swagger al intentar mandar un request por /POST
     		// esto mismo va a ignorar el atributo id por que me la lanza una excepcion por que se envia, y eso esta
     		// mal por que la misma base de datos genere
     		// auto-incrementalmente. En cambio el dto va separar lo que entra de lo que necesita la base por eso esta y lo utilizo
    }

    @GetMapping
    public ResponseEntity<List<Alumno>> listarAlumnos() {
        return ResponseEntity.ok(alumnoService.listarAlumnos());
    }
}