package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.services;


import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.input.ColaboradorInputDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.output.ColaboradorOutputDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;

import java.util.List;

public interface IColaboradorService {
    List<ColaboradorOutputDTO> getColaboradores(Double minPuntos, Integer minDonaciones, Integer limit);
    public void save(Colaborador colaborador);

    public void bulkSave(List<ColaboradorInputDTO> colaboradores);
}
