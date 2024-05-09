package co.edu.unicauca.asae.taller_hexagonal.aplicacion.input;

import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Respuesta;

public interface GestionarRespuestaCUIntPort {
    public Respuesta registrarRespuestaCuestionario(Respuesta objRespuesta);
    public Respuesta consultarRespuestaDocente(Cuestionario objCuestionario, Docente objDocente);
}
