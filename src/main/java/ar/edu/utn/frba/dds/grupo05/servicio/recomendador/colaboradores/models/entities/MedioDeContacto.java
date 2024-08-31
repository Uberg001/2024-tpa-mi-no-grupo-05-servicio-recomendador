package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.Persistente;
import jakarta.persistence.*;

@Entity
@Table(name = "mediosDeContacto")
public class MedioDeContacto extends Persistente {

    @ManyToOne
    @JoinColumn(name = "colaborador_id", referencedColumnName = "id")
    private Colaborador colaborador;

    @Enumerated(EnumType.STRING)
    private TipoMedioDeContacto tipoMedioDeContacto;

    @Column(name="detalle")
    private String detalle;

    public MedioDeContacto(Colaborador colaborador, TipoMedioDeContacto tipoMedioDeContacto, String detalle) {
        this.colaborador = colaborador;
        this.tipoMedioDeContacto = tipoMedioDeContacto;
        this.detalle = detalle;
    }

    public MedioDeContacto(TipoMedioDeContacto tipoMedioDeContacto, String detalle) {
        this.colaborador = colaborador;
        this.tipoMedioDeContacto = tipoMedioDeContacto;
        this.detalle = detalle;
    }

    public MedioDeContacto() {
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public TipoMedioDeContacto getTipoMedioDeContacto() {
        return tipoMedioDeContacto;
    }

    public void setTipoMedioDeContacto(TipoMedioDeContacto tipoMedioDeContacto) {
        this.tipoMedioDeContacto = tipoMedioDeContacto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
