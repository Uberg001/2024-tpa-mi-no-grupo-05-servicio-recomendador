package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.services;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.repositories.IColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorService implements IColaboradorService {
    @Autowired
    private IColaboradorRepository colaboradorRepository;
}
