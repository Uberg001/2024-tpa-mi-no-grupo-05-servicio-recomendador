package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ColaboradorDTO {
    @JsonProperty("nro_documento")
    private String nroDocumento;

    @JsonProperty("tipo_documento")
    private String tipoDocumento;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;

    @JsonProperty("medios_de_contacto")
    private List<MedioDeConctactoDTO> mediosDeContacto;

    @JsonProperty("puntos")
    private Double puntos;

    @JsonProperty("donaciones")
    private Integer donaciones;

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
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

    public List<MedioDeConctactoDTO> getMediosDeContacto() {
        return mediosDeContacto;
    }

    public void setMediosDeContacto(List<MedioDeConctactoDTO> mediosDeContacto) {
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
