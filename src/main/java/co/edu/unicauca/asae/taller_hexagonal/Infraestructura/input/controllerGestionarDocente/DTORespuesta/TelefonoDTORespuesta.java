package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.DTORespuesta;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TelefonoDTORespuesta {
    private int idTelefono;
    private String tipoTelefono;
    private String numero;
    private Docente objDocente;

    public TelefonoDTORespuesta(int idTelefono, String tipoTelefono, String numero, Docente objDocente) {
        this.idTelefono = idTelefono;
        this.tipoTelefono = tipoTelefono;
        this.numero = numero;
        this.objDocente = objDocente;
    }
}
