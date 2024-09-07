package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.utils;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.exceptions.InvalidSortStringException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortStringValidatorTest {

    SortStringValidator sortStringValidator;

    @BeforeEach
    void setUp() {
        this.sortStringValidator = new SortStringValidator();
        this.sortStringValidator.agregarPropiedad("puntos");
        this.sortStringValidator.agregarPropiedad("donaciones");
    }

    @Test
    void unCriterioDeOrdenamiento() {
        this.sortStringValidator.validate("puntos,desc");
        assertDoesNotThrow(() -> this.sortStringValidator.validate("puntos,desc"));
    }

    @Test
    void variosCriteriosDeOrdenamiento() {
        this.sortStringValidator.validate("puntos,desc;donaciones,asc");
        assertDoesNotThrow(() -> this.sortStringValidator.validate("puntos,desc;donaciones,asc"));
    }

    @Test
    void sinCriterioDeOrdenamiento() {
        this.sortStringValidator.validate("");
        assertDoesNotThrow(() -> this.sortStringValidator.validate(""));
    }

    @Test
    void criteriosSinOrden() {
        this.sortStringValidator.validate("puntos;donaciones");
        assertDoesNotThrow(() -> this.sortStringValidator.validate("puntos;donaciones"));
    }

    @Test
    void criteriosInvalidos() {
        assertThrows(InvalidSortStringException.class, () -> this.sortStringValidator.validate("puntos,invalid"));
    }

    @Test
    void criteriosInvalidos2() {
        assertThrows(InvalidSortStringException.class, () -> this.sortStringValidator.validate("puntos,desc;donaciones,invalid"));
    }

    @Test
    void criteriosInvalidos3() {
        assertThrows(InvalidSortStringException.class, () -> this.sortStringValidator.validate("puntos,desc;donaciones,asc;invalid"));
    }

    @Test
    void empiezaConSemicolon() {
        assertThrows(InvalidSortStringException.class, () -> this.sortStringValidator.validate(";puntos,desc"));
    }

    @Test
    void validadorSinPropiedades() {
        SortStringValidator sortStringValidator = new SortStringValidator();
        assertDoesNotThrow(() -> sortStringValidator.validate("puntos,desc"));
    }

}