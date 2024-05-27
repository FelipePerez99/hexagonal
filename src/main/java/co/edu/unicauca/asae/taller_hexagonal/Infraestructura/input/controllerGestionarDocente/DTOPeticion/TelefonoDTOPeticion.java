package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.DTOPeticion;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TelefonoDTOPeticion {
    private int idTelefono;

    @NotNull(message = "{telefono.tipoTelefono.empty}")
    @Size(min = 5, max = 15, message = "{telefono.tipoTelefono.size}")
    private String tipoTelefono;

    @Pattern(message = "El número debe empezar por 3 y contener 10 digitos", regexp = "3\\d{9}")
    private String numero;
    private Docente objDocente;

    public TelefonoDTOPeticion(int idTelefono, String tipoTelefono, String numero, Docente objDocente) {
        this.idTelefono = idTelefono;
        this.tipoTelefono = tipoTelefono;
        this.numero = numero;
        this.objDocente = objDocente;
    }
}
