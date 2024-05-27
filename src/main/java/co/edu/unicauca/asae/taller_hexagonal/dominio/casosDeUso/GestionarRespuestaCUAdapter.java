package co.edu.unicauca.asae.taller_hexagonal.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.taller_hexagonal.aplicacion.input.GestionarRespuestaCUIntPort;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.GestionarRespuestaGatewayIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Peticion;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Respuesta;

public class GestionarRespuestaCUAdapter implements GestionarRespuestaCUIntPort{

    private final GestionarRespuestaGatewayIntPort objRespuestaGatewayInt;
    private final FormateadorResultadosIntPort objFormateadorResultadosInt;

    public GestionarRespuestaCUAdapter(GestionarRespuestaGatewayIntPort objRespuestaGatewayInt,
        FormateadorResultadosIntPort objFormateadorResultadosInt) {
        this.objRespuestaGatewayInt = objRespuestaGatewayInt;
        this.objFormateadorResultadosInt = objFormateadorResultadosInt;
    }

    @Override
    public List<Respuesta> registrarRespuestaCuestionario(Peticion objPeticion) {
        List<Respuesta> objRespuestasCreadas = null;
        if (this.objRespuestaGatewayInt.respuestaMismoCuestionario(objPeticion.getCuestionario(), objPeticion.getDocente())) {
            this.objFormateadorResultadosInt
                    .retornarRespuestaErrorEntidadExiste(
                            "Error, el docente ya respondió este cuestionario");
        } else {
            objRespuestasCreadas = this.objRespuestaGatewayInt.guardar(objPeticion);
        }
        return objRespuestasCreadas;
    }

    @Override
    public Peticion consultarRespuestaDocente(Cuestionario objCuestionario, Docente objDocente) {
        Peticion peticionObtenida = objRespuestaGatewayInt.respuestaCuestionarioPorProfesor(objDocente, objCuestionario);
        //for(Respuesta respuesta : respuestas){
        //    Peticion peticion = new Peticion();
        //    peticion.setCuestionarioDTOPeticion(null);
        //}
        return peticionObtenida;
    }
    
}
