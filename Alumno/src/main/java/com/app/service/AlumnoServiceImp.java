package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.Alumno;
import com.app.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp implements AlumnoService {

	private final AlumnoRepository alumnoRepository;

	public AlumnoServiceImp(AlumnoRepository alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}

	@Override
	public Alumno altaAlumno(Alumno alumno) {
//        alumno.setId(null); // esta validacion la agrego por una cuestion que en el momento de usar swagger al intentar mandar un request por /POST
		// esta misma me la lanza una excepcion por que se envia con el id, y eso esta
		// mal por que la misma base de datos genere
		// auto-incrementalmente el id por si sola. Por eso es mismo es null.
		return alumnoRepository.save(alumno);
	}

	@Override
	public List<Alumno> listarAlumnos() {
		return alumnoRepository.findAll();
	}
}