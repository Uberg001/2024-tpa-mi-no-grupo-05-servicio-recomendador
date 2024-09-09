package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.utils;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.constants.PropertyNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PageableFactory {

    SortStringValidator sortStringValidator;

    public void setSortStringValidator(SortStringValidator sortStringValidator) {
        this.sortStringValidator = sortStringValidator;
    }

    public Pageable createPageableFromSortString(int page, int size, String sortString) {

        sortStringValidator.validate(sortString);

        List<Sort.Order> orders = Arrays.stream(sortString.split(";"))
                .filter(s -> !s.isEmpty())
                .map(this::createOrder)
                .toList();

        return PageRequest.of(page, size, Sort.by(orders));
    }

    private Sort.Order createOrder(String orderString) {
        String[] parts = orderString.split(",");
        String property = parts[0];
        // Default to desc if no direction is provided
        Sort.Direction direction = parts.length > 1 ? Sort.Direction.fromString(parts[1]) : Sort.Direction.DESC;
        return new Sort.Order(direction, property);
    }
}
