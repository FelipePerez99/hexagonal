package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarCuestionario.DTORespuesta;

import java.util.List;

import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Respuesta;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.TipoPregunta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PreguntaDTORespuesta {
    private int idPregunta;
    private String enunciado;
    private Cuestionario objCuestionario;
    private List<Respuesta> respuestas;
    private TipoPregunta objTipoPregunta;
}
