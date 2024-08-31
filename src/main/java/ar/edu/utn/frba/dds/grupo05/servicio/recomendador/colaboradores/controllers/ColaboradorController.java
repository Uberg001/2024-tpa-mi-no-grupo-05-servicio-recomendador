package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.controllers;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.output.ColaboradorOutputDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.services.IColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ColaboradorController {

    @Autowired
    private IColaboradorService colaboradorService;

    @GetMapping("/colaboradores")
    public ResponseEntity<List<ColaboradorOutputDTO>> getColaboradores(
            @RequestParam(value = "minPuntos") Double minPuntos,
            @RequestParam(value = "minDonaciones") Integer minDonaciones,
            @RequestParam(value= "limit") Integer limit
    ) {

        return ResponseEntity.ok(
                Arrays.asList(
                        new ColaboradorOutputDTO()
                )
        );
    }
}
