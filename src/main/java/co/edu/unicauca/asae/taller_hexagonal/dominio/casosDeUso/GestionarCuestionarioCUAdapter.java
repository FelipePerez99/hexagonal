package co.edu.unicauca.asae.taller_hexagonal.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asae.taller_hexagonal.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;

public class GestionarCuestionarioCUAdapter implements GestionarCuestionarioCUIntPort{

    private final GestionarCuestionarioGatewayIntPort objCuestionarioGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarCuestionarioCUAdapter(GestionarCuestionarioGatewayIntPort objCuestionarioGateway, FormateadorResultadosIntPort objFormateadorResultados) {
        this.objCuestionarioGateway = objCuestionarioGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public Cuestionario crear(Cuestionario objCuestionario) {
        Cuestionario objCuestionarioCreado = null;
        if(this.objCuestionarioGateway.existeCuestionarioPorTitulo(objCuestionario.getTitulo())){
            this.objFormateadorResultados.retornarRespuestaErrorEntidadExiste("Error, se encuentra en el sistema un cuestionario con el titulo");
        }else{
            objCuestionarioCreado = this.objCuestionarioGateway.guardar(objCuestionario);
        }
        return objCuestionarioCreado;
    }

    @Override
    public List<Cuestionario> listar() {
        List<Cuestionario> listaObtenida = objCuestionarioGateway.listar();
        return listaObtenida;
    }
    
}
