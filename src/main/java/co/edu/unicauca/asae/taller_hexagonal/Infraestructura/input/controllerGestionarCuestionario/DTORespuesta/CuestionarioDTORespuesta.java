package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarCuestionario.DTORespuesta;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuestionarioDTORespuesta {
    private int idCuestionario;
    private String titulo;
    private String descripcion;
    private List<PreguntaDTORespuesta> preguntas;

    public void agregarPregunta(PreguntaDTORespuesta pregunta){
        this.preguntas.add(pregunta);
    }
}
