package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.configuracion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarCuestionario.DTOPeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarCuestionario.DTORespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarCuestionario.mappers.CuestionarioMapperInfraestructuraDominio;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.casosDeUso.GestionarCuestionarioCUAdapter;
import co.edu.unicauca.asae.taller_hexagonal.dominio.casosDeUso.GestionarDocenteCUAdapter;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;

@Configuration
public class BeanConfigurations {
    @Bean
    public GestionarCuestionarioCUAdapter crearGestionarCuestionarioCUInt(
            GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway,
            FormateadorResultadosIntPort objFormateadorResultados) {
        GestionarCuestionarioCUAdapter objGestionarCuestionarioCU = new GestionarCuestionarioCUAdapter(objGestionarCuestionarioGateway,
                objFormateadorResultados);
        return objGestionarCuestionarioCU;
    }

    @Bean
    public GestionarDocenteCUAdapter crearGestionarDocenteCUInt(
            GestionarDocenteGatewayIntPort objDocenteGateway,
            FormateadorResultadosIntPort objDocenteFormateadoResultados) {
        GestionarDocenteCUAdapter objGestionarDocenteCU = new GestionarDocenteCUAdapter(objDocenteGateway,
                objDocenteFormateadoResultados);
        return objGestionarDocenteCU;
    }

}
