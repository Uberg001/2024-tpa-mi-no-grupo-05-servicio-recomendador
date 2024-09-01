package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.services;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.TipoDocumento;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.repositories.IColaboradorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ColaboradorServiceTest {

    @Autowired
    private IColaboradorRepository colaboradorRepository;

    @BeforeEach
    public void setUp() {

        for (int i = 0; i < 50; i++) {
            Colaborador colaborador = new Colaborador("12345678", TipoDocumento.DNI, String.valueOf(i) + " 10", "Colaborador");
            Double puntosRandom = 10.0;
            Integer donacionesRandom = 10;
            colaborador.setPuntos(puntosRandom);
            colaborador.setDonaciones(donacionesRandom);
            colaboradorRepository.save(colaborador);
        }

        for (int i = 0; i < 50; i++) {
            Colaborador colaborador = new Colaborador("12345678", TipoDocumento.DNI, String.valueOf(i) + " 45", "Colaborador");
            Double puntosRandom = 45.0;
            Integer donacionesRandom = 45;
            colaborador.setPuntos(puntosRandom);
            colaborador.setDonaciones(donacionesRandom);
            colaboradorRepository.save(colaborador);
        }

        for (int i = 0; i < 50; i++) {
            Colaborador colaborador = new Colaborador("12345678", TipoDocumento.DNI, String.valueOf(i) + " 80", "Colaborador");
            Double puntosRandom = 80d;
            Integer donacionesRandom = 80;
            colaborador.setPuntos(puntosRandom);
            colaborador.setDonaciones(donacionesRandom);
            colaboradorRepository.save(colaborador);
        }
    }

    @Test
    public void getColaboradoresTest() {
        Pageable pageable = Pageable.ofSize(10);
        List<Colaborador> colaboradores = colaboradorRepository
                .findByPuntosGreaterThanEqualAndDonacionesGreaterThanEqual(pageable,50.0, 50);
        assertTrue(colaboradores.size()==10);
        assertEquals(colaboradores.stream().allMatch(colaborador -> colaborador.getPuntos() >= 50.0), true);
        assertEquals(colaboradores.stream().allMatch(colaborador -> colaborador.getDonaciones() >= 50), true);
    }
}