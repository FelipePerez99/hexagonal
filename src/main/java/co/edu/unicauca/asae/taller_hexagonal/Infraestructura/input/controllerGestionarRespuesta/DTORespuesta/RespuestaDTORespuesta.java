package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.DTORespuesta;

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
public class RespuestaDTORespuesta {
    private int idRespuesta;
    private String enunciado;
    private Pregunta objPregunta;
    private Docente objDocente;
}
