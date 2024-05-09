package co.edu.unicauca.asae.taller_hexagonal.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuestionario {
    private int idCuestionario;
    private String titulo;
    private String descripcion;
    private List<Pregunta> preguntas;
}
