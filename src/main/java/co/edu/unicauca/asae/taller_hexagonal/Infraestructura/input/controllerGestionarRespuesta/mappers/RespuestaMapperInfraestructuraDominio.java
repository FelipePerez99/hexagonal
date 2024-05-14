package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.DTOPeticion.RespuestaDTOPeticion;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.DTORespuesta.RespuestaDTORespuesta;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Respuesta;

@Mapper(componentModel = "spring")
public interface RespuestaMapperInfraestructuraDominio {
    Respuesta mapearDeRespuestaARespuestaDTO(RespuestaDTOPeticion peticion);

    RespuestaDTORespuesta mapearDeRespuestaARespuesta(Respuesta objRespuesta);

    List<RespuestaDTORespuesta> mapearDeRespuestaARespuesta(List<Respuesta> respuestas);
}