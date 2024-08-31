package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities;

public enum TipoMedioDeContacto {
    EMAIL("EMAIL"),
    TELEFONO("TELEGRAM"),
    WHATSAPP("WHATSAPP");

    public final String value;

    private TipoMedioDeContacto(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
