package co.edu.unicauca.asae.taller_hexagonal.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Peticion;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Respuesta;

public interface GestionarRespuestaGatewayIntPort {
    public List<Respuesta> guardar(Peticion objPeticion);
    public List<Peticion> listar();
    public Peticion respuestaCuestionarioPorProfesor(Docente docente, Cuestionario cuestionario);
    public boolean respuestaMismoCuestionario(Cuestionario cuestionario, Docente docente);
}
