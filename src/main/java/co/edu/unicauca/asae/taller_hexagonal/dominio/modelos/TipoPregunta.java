package co.edu.unicauca.asae.taller_hexagonal.dominio.modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPregunta {
    private int idTipoPregunta;
    private String nombre;
    private String descripcion;
    private List<Pregunta> preguntas;
}
