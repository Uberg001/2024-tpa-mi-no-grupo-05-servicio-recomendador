package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class MedioDeConctactoDTO {
    @NotBlank(message = "El tipo de medio de contacto no puede estar vacío")
    @JsonProperty("tipo_medio_contacto")
    private String tipoMedioDeContacto;

    @NotBlank(message = "El detalle no puede estar vacío")
    @JsonProperty("detalle")
    private String detalle;

    public MedioDeConctactoDTO(String tipoMedioDeContacto, String detalle){
        this.tipoMedioDeContacto = tipoMedioDeContacto;
        this.detalle = detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setTipoMedioDeContacto(String tipoMedioDeContacto) {
        this.tipoMedioDeContacto = tipoMedioDeContacto;
    }

    public String getTipoMedioDeContacto() {
        return tipoMedioDeContacto;
    }
}
