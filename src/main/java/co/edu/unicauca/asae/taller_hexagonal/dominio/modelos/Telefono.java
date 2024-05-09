package co.edu.unicauca.asae.taller_hexagonal.dominio.modelos;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.DocenteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telefono {
    private int idTelefono;
    private String tipoTelefono;
    private String numero;
    private DocenteEntity objDocente;
}
