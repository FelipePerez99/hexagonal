package co.edu.unicauca.asae.taller_hexagonal.dominio.modelos;

import java.util.ArrayList;
import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Docente extends Persona {
    private String correo;
    private String vinculacion;
    private Telefono objTelefono;
    private List<Respuesta> respuestas;
    private List<Departamento> departamentos;
    
    public Docente() {
        super();
        departamentos = new ArrayList<Departamento>();
        respuestas = new ArrayList<Respuesta>();
    }

    public Docente(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos,
            String correo, String vinculacion, Telefono objTelefono) {
        super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.objTelefono = objTelefono;
        departamentos = new ArrayList<Departamento>();
        respuestas = new ArrayList<Respuesta>();
    }
    
    
    
}
