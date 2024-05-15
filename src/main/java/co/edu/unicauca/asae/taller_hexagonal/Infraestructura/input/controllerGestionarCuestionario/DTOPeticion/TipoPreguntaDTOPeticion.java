package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarCuestionario.DTOPeticion;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @Size(min = 3, max = 15, message = "{tipoPregunta.nombre.size}")
    private String nombre;

    @NotNull(message = "{tipoPregunta.descripcion.empty}")
    @Size(min = 10, max = 500, message = "{tipoPregunta.descripcion.size}")
    private String descripcion;
    private List<PreguntaDTOPeticion> preguntas;
}
