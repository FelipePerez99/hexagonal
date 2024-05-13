package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.DTOPeticion;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.DocenteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TelefonoDTOPeticion {
    private int idTelefono;
    private String tipoTelefono;
    private String numero;
    private DocenteEntity objDocente;

    public TelefonoDTOPeticion(int idTelefono, String tipoTelefono, String numero, DocenteEntity objDocente) {
        this.idTelefono = idTelefono;
        this.tipoTelefono = tipoTelefono;
        this.numero = numero;
        this.objDocente = objDocente;
    }
}