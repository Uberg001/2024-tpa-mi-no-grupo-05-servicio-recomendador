package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.mappers;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.output.ColaboradorOutputDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper {
    ColaboradorOutputDTO toDto(Colaborador colaborador);
}
