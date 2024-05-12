package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarCuestionario.DTOPeticion;

import java.util.List;

import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoPreguntaDTOPeticion {
    private int idTipoPregunta;
    private String nombre;
    private String descripcion;
    private List<PreguntaDTOPeticion> preguntas;
}
