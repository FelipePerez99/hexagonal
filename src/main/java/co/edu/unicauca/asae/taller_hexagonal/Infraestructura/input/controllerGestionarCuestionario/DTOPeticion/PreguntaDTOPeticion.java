package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarCuestionario.DTOPeticion;

import java.util.List;

import javax.validation.constraints.NotNull;

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
public class PreguntaDTOPeticion {
    private int idPregunta;
    
    @NotNull(message = "{pregunta.preguntas.empty}")
    private String enunciado;
    private Cuestionario objCuestionario;
    private List<Respuesta> respuestas;
    private TipoPregunta objTipoPregunta;
}
