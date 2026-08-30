package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.CursoConDocenteDTO;
import com.app.model.Curso;

public interface CursoService {
    Curso altaCursos(Curso curso);
    List<Curso> listarCursos();
    Optional<Curso> obtenerPorId(Long id);
    CursoConDocenteDTO obtenerConDocente(Long cursoId);
}