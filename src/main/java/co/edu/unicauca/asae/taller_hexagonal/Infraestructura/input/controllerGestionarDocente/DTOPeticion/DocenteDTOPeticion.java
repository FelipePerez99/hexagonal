package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.DTOPeticion;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Departamento;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Respuesta;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Telefono;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocenteDTOPeticion extends PersonaDTOPeticion {
    //{docente.correo.emply}
    @NotNull(message = "El correo no tiene el formato correcto")
    @Email(message = "{docente.correo.format}")
    private String correo;

    @NotNull(message = "{docente.vinculacion.empty}")
    private String vinculacion;

    @Valid
    private Telefono objTelefono;
    private List<Respuesta> respuestas;
    private List<Departamento> departamentos;
    
    public DocenteDTOPeticion() {
        super();
        departamentos = new ArrayList<Departamento>();
        respuestas = new ArrayList<Respuesta>();
    }

    public DocenteDTOPeticion(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos,
        String correo, String vinculacion, Telefono objTelefono) {
        super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.objTelefono = objTelefono;
        departamentos = new ArrayList<Departamento>();
        respuestas = new ArrayList<Respuesta>();
    }
}
