package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.utils;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.exceptions.InvalidSortStringException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

class ColaboradorPageableFactoryTest {

    private ColaboradorPageableFactory colaboradorPageableFactory;

    @BeforeEach
    void setUp() {
        SortStringValidator sortStringValidator = new SortStringValidator();
        sortStringValidator.agregarPropiedad("puntos");
        sortStringValidator.agregarPropiedad("donaciones");
        colaboradorPageableFactory = new ColaboradorPageableFactory(sortStringValidator);
    }

    @Test
    void unCriterioDeOrdenamiento() {
        Pageable pageable = colaboradorPageableFactory
                .createPageableFromSortString(0, 10, "puntos,desc");

        assertEquals(0, pageable.getPageNumber());
        assertEquals(10, pageable.getPageSize());
        assertEquals(1, pageable.getSort().stream().count());
        assertTrue(pageable.getSort().getOrderFor("puntos").isDescending());
    }

    @Test
    void variosCriteriosDeOrdenamiento() {
        Pageable pageable = colaboradorPageableFactory
                .createPageableFromSortString(1, 20, "puntos,desc;donaciones,asc");

        assertEquals(1, pageable.getPageNumber());
        assertEquals(20, pageable.getPageSize());
        assertEquals(2, pageable.getSort().stream().count());
        assertTrue(pageable.getSort().getOrderFor("puntos").isDescending());
        assertTrue(pageable.getSort().getOrderFor("donaciones").isAscending());
    }

    @Test
    void sinCriterioDeOrdenamiento() {
        Pageable pageable = colaboradorPageableFactory.createPageableFromSortString(0, 10, "");

        assertEquals(0, pageable.getPageNumber());
        assertEquals(10, pageable.getPageSize());
        assertTrue(pageable.getSort().isEmpty());
    }

    @Test
    void direccionInvalida() {
        assertThrows(InvalidSortStringException.class, () ->
                colaboradorPageableFactory.createPageableFromSortString(0, 10, "puntos,invalid")
        );
    }

    @Test
    void defaultDescSiNoSeDaOrden() {
        Pageable pageable = colaboradorPageableFactory
                .createPageableFromSortString(0, 10, "puntos;donaciones");

        assertEquals(0, pageable.getPageNumber());
        assertEquals(10, pageable.getPageSize());
        assertEquals(2, pageable.getSort().stream().count());
        assertTrue(pageable.getSort().getOrderFor("puntos").isDescending());
        assertTrue(pageable.getSort().getOrderFor("donaciones").isDescending());
    }
}