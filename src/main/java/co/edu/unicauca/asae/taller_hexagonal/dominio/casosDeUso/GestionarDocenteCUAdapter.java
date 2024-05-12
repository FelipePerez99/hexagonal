package co.edu.unicauca.asae.taller_hexagonal.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.taller_hexagonal.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort {

    private final GestionarDocenteGatewayIntPort objDocenteGatewayInt;
    private final FormateadorResultadosIntPort objFormateadorResultadosInt;

    

    public GestionarDocenteCUAdapter(GestionarDocenteGatewayIntPort obDocenteGatewayInt,
        FormateadorResultadosIntPort objFormateadorResultadosInt) {
        this.objDocenteGatewayInt = obDocenteGatewayInt;
        this.objFormateadorResultadosInt = objFormateadorResultadosInt;
    }

    @Override
    public Docente registrar(Docente objDocente) {
        Docente objDocenteCreado = null;
        if (this.objDocenteGatewayInt.existeDocentePorIdentificacion(objDocente.getNumeroIdentificacion())) {
            this.objFormateadorResultadosInt
                    .retornarRespuestaErrorEntidadExiste(
                            "Error, se encuentra en el sistema un docente con esa identificación");
        } else if (this.objDocenteGatewayInt.existeDocentePorCorreo(objDocente.getCorreo())) {
            this.objFormateadorResultadosInt.retornarRespuestaErrorCorreoExiste(
                    "Error, se encuentra en el sistema un docente con el mismo correo");
        } else {
            objDocenteCreado = this.objDocenteGatewayInt.guardar(objDocente);
        }
        return objDocenteCreado;
    }

    @Override
    public List<Docente> listar() {
        List<Docente> listaObtenida = objDocenteGatewayInt.listar();
        return listaObtenida;
    }
    
}
