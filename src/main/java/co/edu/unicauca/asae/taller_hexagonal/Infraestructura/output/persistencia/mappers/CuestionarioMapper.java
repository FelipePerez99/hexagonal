package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.mappers;

import org.modelmapper.TypeMap;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Pregunta;

@Configuration
public class CuestionarioMapper {
    @Bean
    @Qualifier("cuestionarioMapper")
    public ModelMapper mapper(){
        ModelMapper objMapper = new ModelMapper();
        TypeMap<CuestionarioEntity, Cuestionario> mapa = objMapper.emptyTypeMap(CuestionarioEntity.class, Cuestionario.class);
        TypeMap<PreguntaEntity, Pregunta> mapa1 = objMapper.emptyTypeMap(PreguntaEntity.class, Pregunta.class);
        mapa.addMappings(m -> m.skip(Cuestionario::setPreguntas)).implicitMappings();
        mapa1.addMappings(m -> m.skip(Pregunta::setObjCuestionario)).implicitMappings();
        //mapa.addMappings(m -> m.skip(Docente::setPublicaciones)).implicitMappings();
        //mapa.addMapping(m -> m.getPreguntas(), (dest, value) -> dest.setPreguntas(null));
        return objMapper;
    }
}
