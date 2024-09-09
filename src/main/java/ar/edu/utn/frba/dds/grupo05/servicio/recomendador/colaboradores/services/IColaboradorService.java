package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.services;


import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.ColaboradorInputDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.ColaboradorOutputDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;

import java.util.List;

public interface IColaboradorService {
    List<ColaboradorOutputDTO> getColaboradores(Double minPuntos,
                                                Integer minDonaciones,
                                                Integer page,
                                                Integer limit,
                                                String sortString);

    public void save(Colaborador colaborador);

    public void bulkSaveOrUpdate(List<ColaboradorInputDTO> colaboradores);
}
