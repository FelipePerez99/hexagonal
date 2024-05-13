package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class docenteMapper {
    @Bean
    @Qualifier("docenteMapper")
    public ModelMapper modelMapper() {
        ModelMapper objMapper = new ModelMapper();
        return objMapper;
    }
}
