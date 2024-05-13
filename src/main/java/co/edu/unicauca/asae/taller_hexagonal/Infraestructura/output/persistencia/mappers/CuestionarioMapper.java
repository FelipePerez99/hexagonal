package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.mappers;

import org.modelmapper.TypeMap;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.TipoPreguntaEntity;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Pregunta;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.TipoPregunta;

@Configuration
public class CuestionarioMapper {
   
      @Bean
      @Qualifier("cuestionarioMapper")
      public ModelMapper mapperCuestionario() {
      ModelMapper objMapper = new ModelMapper();
      
      // Mapeo de TipoPreguntaEntity a TipoPregunta en las preguntas
      TypeMap<TipoPreguntaEntity, TipoPregunta> tipoPreguntaMap = objMapper.emptyTypeMap(TipoPreguntaEntity.class, TipoPregunta.class);
      tipoPreguntaMap.addMappings(m -> m.skip(TipoPregunta::setPreguntas)).implicitMappings();

      // Mapeo de PreguntaEntity a Pregunta en la lista de preguntas del Cuestionario
      TypeMap<PreguntaEntity, Pregunta> preguntaMap = objMapper.emptyTypeMap(PreguntaEntity.class, Pregunta.class);
      preguntaMap.addMappings(m -> m.skip(Pregunta::setObjCuestionario)).implicitMappings();

      // Mapeo de CuestionarioEntity a Cuestionario
      TypeMap<CuestionarioEntity, Cuestionario> cuestionarioMap = objMapper.emptyTypeMap(CuestionarioEntity.class, Cuestionario.class);
      cuestionarioMap.implicitMappings();
      
      return objMapper;
      }
     
}
