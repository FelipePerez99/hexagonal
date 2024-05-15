package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.DTOPeticion;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaDTOPeticion {
    private int idRespuesta;

    @NotNull(message = "{respuesta.enunciado.empty}")
    @Size(min = 10, max = 500, message = "{respuesta.enunciado.size}")
    private String enunciado;
    private Pregunta objPregunta;
    private Docente objDocente;
}
