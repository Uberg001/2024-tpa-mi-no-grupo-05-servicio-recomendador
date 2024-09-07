package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.mappers;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.ColaboradorDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper {
    ColaboradorDTO toDto(Colaborador colaborador);

    List<ColaboradorDTO> toColaboradorOutputDTOList(List<Colaborador> colaboradores);

    List<Colaborador> toColaboradorFromInputDTO(List<ColaboradorDTO> colaboradoresInput);
}
