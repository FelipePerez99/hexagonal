package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.DTOPeticion;

import java.util.List;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarCuestionario.DTOPeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarCuestionario.DTOPeticion.PreguntaDTOPeticion;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeticionDTO {
    private DocenteDTOPeticion docente;
    private CuestionarioDTOPeticion cuestionario;
    private List<PreguntaDTOPeticion> listaPreguntas;
}
