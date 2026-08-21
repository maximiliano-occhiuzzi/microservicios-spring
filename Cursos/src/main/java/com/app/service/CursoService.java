package com.app.service;

import java.util.List;

import com.app.model.Curso;

public interface CursoService {
	  Curso altaCursos(Curso curso);

	    List<Curso> listarCursos();
}
