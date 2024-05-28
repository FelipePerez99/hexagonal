package co.edu.unicauca.asae.taller_hexagonal.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Peticion;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Respuesta;

public interface GestionarRespuestaCUIntPort {
    public List<Respuesta> registrarRespuestaCuestionario(Peticion objPeticion);
    public Peticion consultarRespuestaDocente(Cuestionario objCuestionario, String idDocente);
}
