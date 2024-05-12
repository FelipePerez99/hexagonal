package co.edu.unicauca.asae.taller_hexagonal.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;

public interface GestionarDocenteCUIntPort {
    public Docente registrar(Docente objDocente);
    public List<Docente> listar();
}
