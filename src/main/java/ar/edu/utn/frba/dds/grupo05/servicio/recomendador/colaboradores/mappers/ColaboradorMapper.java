package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.mappers;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.input.ColaboradorInputDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.output.ColaboradorOutputDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper {
    ColaboradorOutputDTO toDto(Colaborador colaborador);

    List<ColaboradorOutputDTO> toColaboradorOutputDTOList(List<Colaborador> colaboradores);

    List<Colaborador> toColaboradorFromInputDTO(List<ColaboradorInputDTO> colaboradoresInput);
}
