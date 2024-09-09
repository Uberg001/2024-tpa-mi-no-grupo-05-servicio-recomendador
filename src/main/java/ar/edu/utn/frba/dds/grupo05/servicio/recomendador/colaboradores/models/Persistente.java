package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models;

import jakarta.persistence.*;

@MappedSuperclass
public class Persistente {
    @Id
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
