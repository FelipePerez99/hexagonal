package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.DTOPeticion;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonaDTOPeticion {
    private int idPersona;
    private String tipoIdentificacion;
    @NotNull(message = "{docente.identificacion.emply}")
    @Size(min = 5, max = 10, message = "{docente.identificacion.size}")
    private String numeroIdentificacion;

    @NotNull(message = "{docente.nombre.emply}")
    @Size(min = 5, max = 45, message = "{docente.nombre.size}")
    private String nombres;

    @NotNull(message = "{docente.apellido.emply}")
    @Size(min = 5, max = 45, message = "{docente.apellido.size}")
    private String apellidos;

    public PersonaDTOPeticion(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
}
