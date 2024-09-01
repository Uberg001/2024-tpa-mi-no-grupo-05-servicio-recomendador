package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.controllers;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.output.ColaboradorOutputDTO;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.services.IColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    private IColaboradorService colaboradorService;

    @Autowired
    public ColaboradorController(IColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorOutputDTO>> getColaboradores(
            @RequestParam(value = "minPuntos", required = true) Double minPuntos,
            @RequestParam(value = "minDonaciones", required = true) Integer minDonaciones,
            @RequestParam(value= "limit", defaultValue = "10") Integer limit
    ) {
        return ResponseEntity.ok(
                colaboradorService.getColaboradores(minPuntos, minDonaciones, limit)
        );
    }
}
