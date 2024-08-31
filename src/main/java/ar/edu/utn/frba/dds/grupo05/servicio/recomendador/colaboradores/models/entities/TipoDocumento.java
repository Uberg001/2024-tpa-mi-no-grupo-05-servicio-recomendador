package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities;

public enum TipoDocumento {
    DNI("DNI"),
    LC("LC"),
    LE("LE"),
    PASAPORTE("PASAPORTE");

    public final String value;

    private TipoDocumento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
