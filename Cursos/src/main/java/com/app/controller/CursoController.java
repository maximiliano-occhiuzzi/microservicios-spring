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

import com.app.dto.CursoAltaDTO;
import com.app.model.Curso;
import com.app.service.CursoService;

@RestController
@RequestMapping("/cursos")

public class CursoController {

	private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    @PostMapping
    public ResponseEntity<Curso> altaCursos(@RequestBody CursoAltaDTO dto) {
        Curso nuevo = new Curso();
        nuevo.setCiclo_lectivo(dto.ciclo_lectivo());
        nuevo.setDivision(dto.division());
        nuevo.setGrado(dto.grado());
        nuevo.setTurno(dto.turno());
        nuevo.setCupo_maximo(dto.cupo_maximo());
        nuevo.setDocenteId(dto.docenteId());   // <- esto faltaba

        Curso creado = cursoService.altaCursos(nuevo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
     // este DTO la agrego por una cuestion que en el momento de usar swagger al intentar mandar un request por /POST
     		// esto mismo va a ignorar el atributo id por que me la lanza una excepcion por que se envia, y eso esta
     		// mal por que la misma base de datos genere
     		// auto-incrementalmente. En cambio el dto va separar lo que entra de lo que necesita la base por eso esta y lo utilizo
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listarAlumnos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }
}