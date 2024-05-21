package co.edu.unicauca.asae.taller_hexagonal.aplicacion.output;

import java.util.List;

import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;

public interface GestionarCuestionarioGatewayIntPort {
    public Cuestionario guardar(Cuestionario objCuestionario);
    public List<Cuestionario> listar();
    public List<Cuestionario> consultarPorTitulo(String titulo);
    public boolean existeCuestionarioPorTitulo(String titulo);
}
