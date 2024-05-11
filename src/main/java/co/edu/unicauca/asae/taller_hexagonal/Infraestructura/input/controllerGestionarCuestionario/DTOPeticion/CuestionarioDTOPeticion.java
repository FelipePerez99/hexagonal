package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarCuestionario.DTOPeticion;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CuestionarioDTOPeticion {
    private int idCuestionario;

    @NotNull(message = "{cuestionario.titulo.empty}")
    @Size(min = 5, max = 100, message = "{cuestionario.titulo.size}")
    private String titulo;

    @NotNull(message = "{cuestionario.descripcion.empty}")
    @Size(min = 10, max = 500, message = "{cuestionario.descripcion.size}")
    private String descripcion;

    @NotEmpty(message = "{cuestionario.preguntas.empty}")
    @NotNull(message = "{cuestionario.preguntas.empty}")
    private List<Pregunta> preguntas;
}
