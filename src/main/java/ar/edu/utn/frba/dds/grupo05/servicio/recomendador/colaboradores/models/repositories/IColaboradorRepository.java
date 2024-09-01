package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.repositories;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IColaboradorRepository extends JpaRepository<Colaborador, Long> {

    List<Colaborador> findByPuntosGreaterThanEqualAndDonacionesGreaterThanEqual(Pageable pageable,
                                                                                Double minPuntos,
                                                                                Integer minDonaciones);
}
