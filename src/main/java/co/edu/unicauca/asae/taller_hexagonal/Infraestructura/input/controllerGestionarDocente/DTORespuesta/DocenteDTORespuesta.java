package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.DTORespuesta;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Departamento;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Respuesta;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Telefono;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DocenteDTORespuesta extends PersonaDTORespuesta {

    private String correo;
    private String vinculacion;
    private Telefono objTelefono;
    private List<Respuesta> respuestas;
    private List<Departamento> departamentos;

    public DocenteDTORespuesta(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos,
        String correo, String vinculacion, Telefono objTelefono) {
        super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.objTelefono = objTelefono;
        this.departamentos = new ArrayList<Departamento>();
        this.respuestas = new ArrayList<Respuesta>();
    }
}
