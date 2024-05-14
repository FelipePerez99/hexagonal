package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.mappers;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.DTOPeticion.PeticionDTO;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.DTORespuesta.PeticionDTORespuesta;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Peticion;

@Mapper(componentModel = "spring")
public interface PeticionMapperInfraestructuraDominio {
    Peticion mapearDePeticionDTOAPeticion(PeticionDTO peticion);

    PeticionDTORespuesta mapearDePeticionARespuesta(Peticion objPeticion);
}
