package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.casosDeUso.GestionarCuestionarioCUAdapter;

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

}
