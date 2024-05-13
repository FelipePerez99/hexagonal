package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;

@Mapper(componentModel = "spring")
public interface DocenteMapperInfraestructuraDominio {
    Docente mapearDePeticionADocente(DocenteDTOPeticion peticion);

    DocenteDTORespuesta mapearDeDocenteARespuesta(Docente objDocente);

    List<DocenteDTORespuesta> mapearDeDocentesARespuesta(List<Docente> docentes);
}
