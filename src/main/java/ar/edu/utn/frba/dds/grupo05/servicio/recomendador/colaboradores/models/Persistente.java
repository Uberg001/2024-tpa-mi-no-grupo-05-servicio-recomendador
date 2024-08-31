package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models;

import jakarta.persistence.*;

@MappedSuperclass
public class Persistente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
