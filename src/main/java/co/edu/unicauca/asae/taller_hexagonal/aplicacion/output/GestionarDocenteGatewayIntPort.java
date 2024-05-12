package co.edu.unicauca.asae.taller_hexagonal.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;

public interface GestionarDocenteGatewayIntPort {
    public Docente guardar(Docente objDocente);
    public List<Docente> listar();
    public boolean existeDocentePorCorreo(String correo);
    public boolean existeDocentePorIdentificacion(String identificacion);
}
