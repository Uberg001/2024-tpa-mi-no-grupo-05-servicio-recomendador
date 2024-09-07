package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.services;


import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.ColaboradorDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;

import java.util.List;

public interface IColaboradorService {
    List<ColaboradorDTO> getColaboradores(Double minPuntos,
                                          Integer minDonaciones,
                                          Integer page,
                                          Integer limit,
                                          String sortString);

    public void save(Colaborador colaborador);

    public void bulkSave(List<ColaboradorDTO> colaboradores);
}
