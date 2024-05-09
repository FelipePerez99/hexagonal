package co.edu.unicauca.asae.taller_hexagonal.dominio.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
    private int idDepartamento;
    private String nombreDep;
    private String descripcion;
}
