package co.edu.unicauca.asae.taller_hexagonal.aplicacion.input;

import java.util.List;

import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;

public interface GestionarCuestionarioCUIntPort {
    public Cuestionario crear(Cuestionario objCuestionario);
    public List<Cuestionario> listar(); 
}
