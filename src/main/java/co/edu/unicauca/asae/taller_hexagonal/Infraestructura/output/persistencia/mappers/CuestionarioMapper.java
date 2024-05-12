package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.mappers;

import org.modelmapper.TypeMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

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
    /*
     * @Bean
     * 
     * @Qualifier("cuestionarioMapper")
     * public ModelMapper mapper(){
     * ModelMapper objMapper = new ModelMapper();
     * TypeMap<CuestionarioEntity, Cuestionario> mapa =
     * objMapper.emptyTypeMap(CuestionarioEntity.class, Cuestionario.class);
     * mapa.addMapping(CuestionarioEntity::getPreguntas,
     * Cuestionario::setPreguntas);
     * //mapa.addMapping(src ->
     * src.getPreguntas().stream().map(PreguntaEntity::getEnunciado).collect(
     * Collectors.toList()), Cuestionario::setPreguntas);
     * mapa.addMapping(m -> m.getPreguntas() != null ?
     * m.getPreguntas().stream().map(PreguntaEntity::getEnunciado).collect(
     * Collectors.toList()) : Collections.emptyList(), Cuestionario::setPreguntas);
     * 
     * 
     * //mapa.addMappings(m ->
     * m.skip(Cuestionario::setPreguntas)).implicitMappings();
     * //mapa.addMappings(m ->
     * m.skip(Docente::setPublicaciones)).implicitMappings();
     * //mapa.addMapping(m -> m.getPreguntas(), (dest, value) ->
     * dest.setPreguntas(null));
     * return objMapper;
     * }
     */

    @Bean
    @Qualifier("cuestionarioMapper")
    public ModelMapper mapper() {
        ModelMapper objMapper = new ModelMapper();

        // Mapeo de PreguntaEntity a Pregunta en la lista de preguntas del Cuestionario
        TypeMap<PreguntaEntity, Pregunta> preguntaMap = objMapper.createTypeMap(PreguntaEntity.class, Pregunta.class)
                .addMapping(PreguntaEntity::getIdPregunta, Pregunta::setIdPregunta)
                .addMapping(PreguntaEntity::getEnunciado, Pregunta::setEnunciado)
                .addMapping(m -> m.getObjCuestionario(), (dest, value) -> dest.setObjCuestionario(null));// Asumiendo que el
                                                                                                // método getTipo()
                                                                                                // retorna el tipo de
                                                                                                // pregunta

        // Mapeo de CuestionarioEntity a Cuestionario
        TypeMap<CuestionarioEntity, Cuestionario> mapa = objMapper
                .createTypeMap(CuestionarioEntity.class, Cuestionario.class)
                .addMapping(src -> src.getPreguntas() != null
                        ? src.getPreguntas().stream().map(preguntaMap::map).collect(Collectors.toList())
                        : Collections.emptyList(), Cuestionario::setPreguntas)
                .addMapping(CuestionarioEntity::getTitulo, Cuestionario::setTitulo)
                .addMapping(CuestionarioEntity::getDescripcion, Cuestionario::setDescripcion);


        return objMapper;
    }

}
