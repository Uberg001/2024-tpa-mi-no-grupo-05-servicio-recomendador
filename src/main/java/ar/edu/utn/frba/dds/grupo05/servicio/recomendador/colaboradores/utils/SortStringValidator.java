package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.utils;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.constants.ErrorMessages;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.exceptions.InvalidSortStringException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SortStringValidator {

    // Si properties esta vacio, solo valida formato del string
    // Sino, valida que las propiedades sean las que se pasaron en agregarPropiedad
    private List<String> properties;

    public SortStringValidator() {
        this.properties = new ArrayList<>();
    }

    public void agregarPropiedad(String propiedad) {
        this.properties.add(propiedad);
    }

    public void validate(String sortString) {
        String propertiesPattern = this.properties.isEmpty() ? "\\w+" : String.join("|", this.properties);
        String regex = "^((" + propertiesPattern + ")(,(asc|desc))?" +
                "(;(" + propertiesPattern + ")(,(asc|desc))?)*)?$";
        // Por ejemplo, si las propiedades son "puntos" y "donaciones", el regex debería ser:
        // ^((puntos|donaciones)(,(asc|desc))?(;(puntos|donaciones)(,(asc|desc))?)*)?$
        if (!sortString.matches(regex)) {
            throw new InvalidSortStringException(ErrorMessages.INVALID_SORT_STRING);
        }
    }

}
