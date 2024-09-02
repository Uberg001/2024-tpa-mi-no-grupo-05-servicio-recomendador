package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.services;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.input.ColaboradorInputDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.output.ColaboradorOutputDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.mappers.ColaboradorMapper;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.repositories.IColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService implements IColaboradorService {

    private IColaboradorRepository colaboradorRepository;
    private ColaboradorMapper colaboradorMapper;

    @Autowired
    public ColaboradorService(IColaboradorRepository colaboradorRepository, ColaboradorMapper colaboradorMapper) {
        this.colaboradorRepository = colaboradorRepository;
        this.colaboradorMapper = colaboradorMapper;
    }

    public void save(Colaborador colaborador) {
        colaboradorRepository.save(colaborador);
    }

    @Override
    public void bulkSave(List<ColaboradorInputDTO> colaboradoresInput) {
        List<Colaborador> colaboradores =  this.colaboradorMapper.toColaboradorFromInputDTO(colaboradoresInput);
        this.colaboradorRepository.saveAll(colaboradores);
    }

    public List<ColaboradorOutputDTO> getColaboradores(Double minPuntos, Integer minDonaciones, Integer limit) {
        Pageable pageable = PageRequest.ofSize(limit);

        List<Colaborador> colaboradores = colaboradorRepository
                .findByPuntosGreaterThanEqualAndDonacionesGreaterThanEqual(pageable, minPuntos, minDonaciones);

        List<ColaboradorOutputDTO> colaboradorOutputDTOS = colaboradorMapper.toColaboradorOutputDTOList(colaboradores);

        return colaboradorOutputDTOS;
    }
}
