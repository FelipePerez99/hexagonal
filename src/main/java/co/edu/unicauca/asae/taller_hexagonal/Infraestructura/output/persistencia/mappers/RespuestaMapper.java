package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.RespuestaEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.TelefonoEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.TipoPreguntaEntity;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Pregunta;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Respuesta;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Telefono;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.TipoPregunta;

@Configuration
public class RespuestaMapper {
    @Bean
    @Qualifier("respuestaMapper")
    public ModelMapper mapperRespuesta() {
      ModelMapper objMapper = new ModelMapper();

      TypeMap<TelefonoEntity, Telefono> TelefonoMap = objMapper.emptyTypeMap(TelefonoEntity.class, Telefono.class);
      TelefonoMap.addMappings(m-> m.skip(Telefono::setObjDocente)).implicitMappings();

      TypeMap<DocenteEntity, Docente> docenteMap = objMapper.emptyTypeMap(DocenteEntity.class, Docente.class);
      docenteMap.addMappings(m -> m.skip(Docente::setRespuestas)).implicitMappings();
      
      TypeMap<CuestionarioEntity, Cuestionario> cuestionarioMap = objMapper.emptyTypeMap(CuestionarioEntity.class, Cuestionario.class);
      cuestionarioMap.implicitMappings();

      TypeMap<TipoPreguntaEntity,TipoPregunta> TipoPreguntaMap = objMapper.emptyTypeMap(TipoPreguntaEntity.class, TipoPregunta.class);
      TipoPreguntaMap.addMappings(m -> m.skip(TipoPregunta::setPreguntas)).implicitMappings();

      TypeMap<PreguntaEntity, Pregunta> preguntaMap = objMapper.emptyTypeMap(PreguntaEntity.class, Pregunta.class);
      preguntaMap.addMappings(m -> m.skip(Pregunta::setObjCuestionario)).implicitMappings();
      
      TypeMap<RespuestaEntity, Respuesta> respuestaMap = objMapper.emptyTypeMap(RespuestaEntity.class, Respuesta.class);
      respuestaMap.addMappings(m -> m.skip(Respuesta::setObjPregunta)).addMappings(m -> m.skip(Respuesta::setObjDocente)).implicitMappings();

      TypeMap<Respuesta, RespuestaEntity> respuestaMap2 = objMapper.emptyTypeMap(Respuesta.class, RespuestaEntity.class);
      respuestaMap2.implicitMappings();
      
      return objMapper;
      }
    }
