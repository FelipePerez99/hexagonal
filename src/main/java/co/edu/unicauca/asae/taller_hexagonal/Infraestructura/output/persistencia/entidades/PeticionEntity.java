package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeticionEntity {
    private DocenteEntity docente;
    private CuestionarioEntity cuestionario;
    private List<PreguntaEntity> listaPreguntas;
}
