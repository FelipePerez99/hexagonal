package co.edu.unicauca.asae.taller_hexagonal.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Peticion {
    private Docente docente;
    private Cuestionario cuestionario;
    private List<Pregunta> listaPreguntas;
}
