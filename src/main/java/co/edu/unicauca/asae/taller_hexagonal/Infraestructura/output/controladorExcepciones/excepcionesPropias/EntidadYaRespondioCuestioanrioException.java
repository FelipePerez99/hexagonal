package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.controladorExcepciones.excepcionesPropias;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import lombok.Getter;

@Getter
public class EntidadYaRespondioCuestioanrioException extends RuntimeException {
    private final String llaveMensaje;
    private final String codigo;

    public EntidadYaRespondioCuestioanrioException(CodigoError code) {
        super(code.getCodigo());
        this.llaveMensaje = code.getLlaveMensaje();
        this.codigo = code.getCodigo();
    }

    public EntidadYaRespondioCuestioanrioException(final String message) {
        super(message);
        this.llaveMensaje = CodigoError.YA_RESPONDIO_CUESTIONARIO.getLlaveMensaje();
        this.codigo = CodigoError.YA_RESPONDIO_CUESTIONARIO.getCodigo();
    }
}
