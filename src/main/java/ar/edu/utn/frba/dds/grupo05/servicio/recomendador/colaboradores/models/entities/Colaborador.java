package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.Persistente;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "colaboradores")
public class Colaborador extends Persistente {
    @Column(name="nroDocumento", length = 20)
    private String nroDocumento;

    @Enumerated(EnumType.STRING)
    @Column(name="tipoDocumento")
    private TipoDocumento tipoDocumento;

    @Column(name="nombre", length = 100)
    private String nombre;

    @Column(name="apellido", length = 100)
    private String apellido;

    @OneToMany(mappedBy = "colaborador")
    private List<MedioDeContacto> mediosDeContacto;

    @Column(name="puntos")
    private Double puntos;

    @Column(name="donaciones")
    private Integer donaciones;

    public Colaborador(String nroDocumento, TipoDocumento tipoDocumento, String nombre, String apellido) {
        this.nroDocumento = nroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mediosDeContacto = new ArrayList<>();
    }

    public void addMedioDeContacto(MedioDeContacto medioDeContacto) {
        this.mediosDeContacto.add(medioDeContacto);
        medioDeContacto.setColaborador(this);
    }

    public Colaborador(String nroDocumento,
                       TipoDocumento tipoDocumento,
                       String nombre,
                       String apellido,
                       List<MedioDeContacto> mediosDeContacto,
                       Double puntos,
                       Integer donaciones) {
        this.nroDocumento = nroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mediosDeContacto = mediosDeContacto;
        this.puntos = puntos;
        this.donaciones = donaciones;
    }

    public Colaborador() {
        this.mediosDeContacto = new ArrayList<>();
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<MedioDeContacto> getMediosDeContacto() {
        return mediosDeContacto;
    }

    public void setMediosDeContacto(List<MedioDeContacto> mediosDeContacto) {
        this.mediosDeContacto = mediosDeContacto;
    }

    public Double getPuntos() {
        return puntos;
    }

    public void setPuntos(Double puntos) {
        this.puntos = puntos;
    }

    public Integer getDonaciones() {
        return donaciones;
    }

    public void setDonaciones(Integer donaciones) {
        this.donaciones = donaciones;
    }
}
