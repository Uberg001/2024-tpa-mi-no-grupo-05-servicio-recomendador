package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.output;

import com.fasterxml.jackson.annotation.JsonProperty;



public class MedioDeConctactoOutputDTO {
    @JsonProperty("tipo_medio_contacto")
    private String tipoMedioDeContacto;

    @JsonProperty("detalle")
    private String detalle;

    public MedioDeConctactoOutputDTO(String tipoMedioDeContacto, String detalle){
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
