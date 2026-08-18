package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Alumno;
import com.app.repository.AlumnoRepository;

import lombok.RequiredArgsConstructor;
//indica q la clase contiene logica de negocio
@Service
//trae un constructor
@RequiredArgsConstructor
public class AlumnoService {
	//indica que el service depende del repositorio

    private final AlumnoRepository alumnoRepository;

    public Alumno altaAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public List<Alumno> listarAlumnos() {
        return alumnoRepository.findAll();
    }
}