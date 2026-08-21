package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Curso;
import com.app.repository.CursoRepository;

@Service
public class CursoServiceImp implements CursoService {
	 private final CursoRepository cursoRepository;

	    public CursoServiceImp(CursoRepository cursoRepository) {
	        this.cursoRepository = cursoRepository;
	    }

	@Override
	public Curso altaCursos(Curso curso) {
	     //curso.setId(null); // esta validacion la agrego por una cuestion que en el momento de usar swagger al intentar mandar un request por /POST
			// esta misma me la lanza una excepcion por que se envia con el id, y eso esta
			// mal por que la misma base de datos genere
			// auto-incrementalmente el id por si sola. Por eso es mismo es null.
			return cursoRepository.save(curso);
	}

	@Override
	public List<Curso> listarCursos() {
        return cursoRepository.findAll();
	}

}
