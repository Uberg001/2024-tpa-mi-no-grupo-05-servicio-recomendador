package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.services;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.ColaboradorInputDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.TipoDocumento;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.repositories.IColaboradorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ColaboradorServiceTest {

    @Autowired
    IColaboradorRepository colaboradorRepository;

    @Autowired
    IColaboradorService colaboradorService;

    List<ColaboradorInputDTO> colaboradores;

    @BeforeEach
    void setUp() {
        this.colaboradores = new ArrayList<>();
        colaboradores
                .add(new ColaboradorInputDTO(51L, "98765432", TipoDocumento.DNI.getValue(), "Juan", "Pérez"));
        colaboradores
                .add(new ColaboradorInputDTO(52L, "12345679", TipoDocumento.PASAPORTE.getValue(), "Ana", "García"));
        colaboradores
                .add(new ColaboradorInputDTO(53L, "87654321", TipoDocumento.LC.getValue(), "Carlos", "Martínez"));
        colaboradores
                .add(new ColaboradorInputDTO(54L, "11223344", TipoDocumento.LE.getValue(), "Lucía", "Fernández"));
        colaboradores
                .add(new ColaboradorInputDTO(55L, "55667788", TipoDocumento.LC.getValue(), "Pedro", "Gómez"));
    }

    @Test
    void bulkSaveTodosNuevos() {
        colaboradorRepository.deleteAll();
        colaboradorService.bulkSaveOrUpdate(colaboradores);
        List<Colaborador> colaboradoresGuardados = colaboradorRepository.findAll();
        assertEquals(colaboradores.size(), colaboradoresGuardados.size());
    }

    @Test
    void bulkSaveYUpdate() {
        colaboradorRepository.deleteAll();
        colaboradorService.bulkSaveOrUpdate(colaboradores);
        List<Colaborador> colaboradoresIniciales = colaboradorRepository.findAll();
        Integer cantAntes = colaboradoresIniciales.size();

        ColaboradorInputDTO c = new ColaboradorInputDTO(51L, "98765432", TipoDocumento.DNI.getValue(), "Juan", "Pérez");
        c.setPuntos(100.0);
        c.setDonaciones(10);
        colaboradores.set(0, c);

        colaboradorService.bulkSaveOrUpdate(colaboradores);

        List<Colaborador> colaboradoresGuardados = colaboradorRepository.findAll();

        assertEquals(cantAntes, colaboradoresGuardados.size());
        assertEquals(100.0, colaboradoresGuardados.get(0).getPuntos());
        assertEquals(10, colaboradoresGuardados.get(0).getDonaciones());
    }
}