package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.repositories;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.MedioDeContacto;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.TipoDocumento;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.TipoMedioDeContacto;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.repositories.IColaboradorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ColaboradorRepositoryTest {

    @Autowired
    private IColaboradorRepository colaboradorRepository;

    @BeforeEach
    public void setUp() {

        for (int i = 0; i < 50; i++) {
            Colaborador colaborador = new Colaborador(Long.valueOf(i), "12345678", TipoDocumento.DNI, String.valueOf(i) + " 10", "Colaborador");
            Double puntosRandom = 10.0;
            Integer donacionesRandom = 10;
            colaborador.setPuntos(puntosRandom);
            colaborador.setDonaciones(donacionesRandom);

            MedioDeContacto medioDeContacto = new MedioDeContacto(TipoMedioDeContacto.EMAIL,
                                                            "colaborador" + i + "@gmail.com");
            colaborador.addMedioDeContacto(medioDeContacto);
            colaboradorRepository.save(colaborador);
        }

        for (int i = 0; i < 50; i++) {
            Colaborador colaborador = new Colaborador(Long.valueOf(i+50),"12345678", TipoDocumento.DNI, String.valueOf(i) + " 45", "Colaborador");
            Double puntosRandom = 45.0;
            Integer donacionesRandom = 45;
            colaborador.setPuntos(puntosRandom);
            colaborador.setDonaciones(donacionesRandom);
            colaboradorRepository.save(colaborador);
        }

        for (int i = 0; i < 50; i++) {
            Colaborador colaborador = new Colaborador(Long.valueOf(i+100),"12345678", TipoDocumento.DNI, String.valueOf(i) + " 80", "Colaborador");
            Double puntosRandom = 80d;
            Integer donacionesRandom = 80;
            colaborador.setPuntos(puntosRandom);
            colaborador.setDonaciones(donacionesRandom);
            colaboradorRepository.save(colaborador);
        }
    }

    @Test
    public void getColaboradoresTest() {
        // Sort by puntos, desc
        Pageable pageable = PageRequest.of(0, 10);
        List<Colaborador> colaboradores = colaboradorRepository
                .findByPuntosGreaterThanEqualAndDonacionesGreaterThanEqual(pageable,50.0, 50);
        assertTrue(colaboradores.size()==10);
        assertEquals(colaboradores.stream().allMatch(colaborador -> colaborador.getPuntos() >= 50.0), true);
        assertEquals(colaboradores.stream().allMatch(colaborador -> colaborador.getDonaciones() >= 50), true);
    }

    @Test
    public void getColarboradoresSortByPuntos() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "puntos");
        Pageable pageRequest = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(order));
        List<Colaborador> colaboradores = colaboradorRepository
                .findByPuntosGreaterThanEqualAndDonacionesGreaterThanEqual(pageRequest, 0d, 0);
        // Verificar orden
        for (int i = 0; i < colaboradores.size() - 1; i++) {
            assertTrue(colaboradores.get(i).getPuntos() >= colaboradores.get(i + 1).getPuntos());
        }
    }

    @Test
    public void getColaboradoresSortByPuntosASC() {
        Sort.Order order = new Sort.Order(Sort.Direction.ASC, "donaciones");
        Pageable pageRequest = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(order));
        List<Colaborador> colaboradores = colaboradorRepository
                .findByPuntosGreaterThanEqualAndDonacionesGreaterThanEqual(pageRequest, 0d, 0);
        // Verificar orden
        for (int i = 0; i < colaboradores.size() - 1; i++) {
            assertTrue(colaboradores.get(i).getDonaciones() <= colaboradores.get(i + 1).getDonaciones());
        }
    }
}