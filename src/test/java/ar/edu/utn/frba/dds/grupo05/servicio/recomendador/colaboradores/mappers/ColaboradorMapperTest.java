package ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.mappers;

import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.dtos.ColaboradorDTO;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.Colaborador;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.MedioDeContacto;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.TipoDocumento;
import ar.edu.utn.frba.dds.grupo05.servicio.recomendador.colaboradores.models.entities.TipoMedioDeContacto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ColaboradorMapperTest {

    @Autowired
    private ColaboradorMapper mapper;

    @Test
    void toOutputDTO() {

        MedioDeContacto emailContacto = new MedioDeContacto(TipoMedioDeContacto.EMAIL,"colaborador@example.com");
        MedioDeContacto whatsappContacto = new MedioDeContacto(TipoMedioDeContacto.WHATSAPP,"+123456789");


        Colaborador colaborador = new Colaborador(
                "123456789",
                TipoDocumento.DNI,
                "Juan",
                "Pérez");


        colaborador.addMedioDeContacto(emailContacto);
        colaborador.addMedioDeContacto(whatsappContacto);

        ColaboradorDTO colaboradorDTO = mapper.toDto(colaborador);

        assertEquals(colaborador.getNombre(), colaboradorDTO.getNombre());
        assertEquals(colaborador.getApellido(), colaboradorDTO.getApellido());
        assertEquals(colaborador.getNroDocumento(), colaboradorDTO.getNroDocumento());
        assertEquals(colaborador.getTipoDocumento().getValue(), colaboradorDTO.getTipoDocumento());
        assertEquals(colaborador.getMediosDeContacto().size(), colaboradorDTO.getMediosDeContacto().size());
        assertEquals(colaborador.getPuntos(), colaboradorDTO.getPuntos());
        assertEquals(colaborador.getDonaciones(), colaboradorDTO.getDonaciones());
        System.out.println(colaboradorDTO);
        // Comparacion de los medios de contacto
    }
}