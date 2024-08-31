package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.repositories;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IColaboradorRepository extends JpaRepository<Colaborador, Long> {

}
