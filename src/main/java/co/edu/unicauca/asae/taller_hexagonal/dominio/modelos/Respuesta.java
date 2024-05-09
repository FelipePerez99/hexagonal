package co.edu.unicauca.asae.taller_hexagonal.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {
    private int idRespuesta;
    private String enunciado;
    private Pregunta objPregunta;
    private Docente objDocente;
}
