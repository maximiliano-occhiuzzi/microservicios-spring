package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.client.DocenteClient;
import com.app.dto.CursoConDocenteDTO;
import com.app.dto.DocenteDTO;
import com.app.model.Curso;
import com.app.repository.CursoRepository;

@Service
public class CursoServiceImp implements CursoService {

    private final CursoRepository cursoRepository;
    private final DocenteClient docenteClient;

    public CursoServiceImp(CursoRepository cursoRepository, DocenteClient docenteClient) {
        this.cursoRepository = cursoRepository;
        this.docenteClient = docenteClient;
    }

    @Override
    public Curso altaCursos(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> obtenerPorId(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public CursoConDocenteDTO obtenerConDocente(Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + cursoId));

        CursoConDocenteDTO dto = new CursoConDocenteDTO();
        dto.setId(curso.getId());
        dto.setCiclo_lectivo(curso.getCiclo_lectivo());
        dto.setDivision(curso.getDivision());
        dto.setGrado(curso.getGrado());
        dto.setTurno(curso.getTurno());
        dto.setCupo_maximo(curso.getCupo_maximo());

        if (curso.getDocenteId() != null) {
            DocenteDTO docente = docenteClient.obtenerPorId(curso.getDocenteId());
            dto.setDocente(docente);
        }

        return dto;
    }
}