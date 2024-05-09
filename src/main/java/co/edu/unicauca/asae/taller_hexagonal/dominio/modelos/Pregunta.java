package co.edu.unicauca.asae.taller_hexagonal.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {
    private int idPregunta;
    private String enunciado;
    private Cuestionario objCuestionario;
    private List<Respuesta> respuestas;
    private TipoPregunta objTipoPregunta;
}
