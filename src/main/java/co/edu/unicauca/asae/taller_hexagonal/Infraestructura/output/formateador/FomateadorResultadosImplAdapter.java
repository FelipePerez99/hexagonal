package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.formateador;

import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioException;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.FormateadorResultadosIntPort;

@Service
public class FomateadorResultadosImplAdapter implements FormateadorResultadosIntPort{

    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        ReglaNegocioException objException = new ReglaNegocioException(mensaje);
        throw objException;
    }
    
}
