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
import co.edu.unicauca.asae.taller_hexagonal.dominio.casosDeUso.GestionarCuestionarioCUAdapter;
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

    /* 
    @Bean
    public CuestionarioMapperInfraestructuraDominio cuestionarioMapperInfraestructuraDominio() {
        return new CuestionarioMapperInfraestructuraDominio() {
            @Override
            public Cuestionario mappearDePeticionACuestionario(CuestionarioDTOPeticion peticion) {
                // Implementación de la lógica de mapeo de DTO a dominio
                Cuestionario cuestionario = new Cuestionario();
                // Aquí deberías implementar la lógica de cómo mapear los atributos del DTO a un objeto Cuestionario
                cuestionario.setTitulo(peticion.getTitulo()); // Ejemplo de mapeo de un atributo
                return cuestionario;
            }

            @Override
            public CuestionarioDTORespuesta mappearDeCuestionarioARespuesta(Cuestionario objCuestionario) {
                // Implementación de la lógica de mapeo de dominio a DTO de respuesta
                CuestionarioDTORespuesta respuesta = new CuestionarioDTORespuesta();
                // Aquí deberías implementar la lógica de cómo mapear los atributos de un objeto Cuestionario a un DTO de respuesta
                respuesta.setTitulo(objCuestionario.getTitulo()); // Ejemplo de mapeo de un atributo
                return respuesta;
            }

            @Override
            public List<CuestionarioDTORespuesta> mappearDeCuestionariosARespuesta(List<Cuestionario> cuestionarios) {
                // Implementación de la lógica de mapeo de una lista de cuestionarios a una lista de DTOs de respuesta
                List<CuestionarioDTORespuesta> respuestas = new ArrayList<>();
                for (Cuestionario cuestionario : cuestionarios) {
                    // Aquí deberías implementar la lógica de cómo mapear cada objeto Cuestionario en la lista a un DTO de respuesta
                    CuestionarioDTORespuesta respuesta = new CuestionarioDTORespuesta();
                    respuesta.setTitulo(cuestionario.getTitulo()); // Ejemplo de mapeo de un atributo
                    respuestas.add(respuesta);
                }
                return respuestas;
            }
        };
    }*/

}
