package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.controllers;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.ColaboradorDTO;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.services.IColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<ColaboradorDTO>> getColaboradores(
            @RequestParam(value = "minPuntos", required = true) Double minPuntos,
            @RequestParam(value = "minDonaciones", required = true) Integer minDonaciones,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value= "limit", defaultValue = "10") Integer limit,
            @RequestParam(value = "sort", defaultValue = "puntos,desc;donaciones,desc") String sortString
    ) {
        return ResponseEntity.ok(
                colaboradorService.getColaboradores(minPuntos, minDonaciones, page, limit, sortString)
        );
    }

    @PostMapping
    public ResponseEntity<Void> updateColaboradoresDB(@RequestBody List<ColaboradorDTO> colaboradores) {
        colaboradorService.bulkSave(colaboradores);
        return ResponseEntity.ok().build();
    }
}
