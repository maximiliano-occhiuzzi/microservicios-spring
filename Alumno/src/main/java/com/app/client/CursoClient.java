package com.app.client;

import com.app.dto.CursoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "modulo-cursos")
public interface CursoClient {

    @GetMapping("/cursos/{id}/con-docente")   // <-- cambia el path
    CursoDTO obtenerPorId(@PathVariable("id") Long id);
}