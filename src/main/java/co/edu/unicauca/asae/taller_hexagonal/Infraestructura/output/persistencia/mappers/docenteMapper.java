package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.TelefonoEntity;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Telefono;


@Configuration
public class DocenteMapper {
    @Bean
    @Qualifier("docenteMapper")
    public ModelMapper mapperDocente() {
      ModelMapper objMapper = new ModelMapper();

      // Mapeo de TelefonoEntity a Pregunta en la lista de preguntas del Telefono
      TypeMap<TelefonoEntity, Telefono> TelefonoMap = objMapper.emptyTypeMap(TelefonoEntity.class, Telefono.class);
      TelefonoMap.addMappings(m-> m.skip(Telefono::setObjDocente)).implicitMappings();

      // Mapeo de DocenteEntity a Docente
      TypeMap<DocenteEntity, Docente> docenteMap = objMapper.emptyTypeMap(DocenteEntity.class, Docente.class);
      docenteMap.addMapping(DocenteEntity::getObjTelefono, Docente::setObjTelefono).implicitMappings();

      TypeMap<Docente, DocenteEntity> docenteMap2 = objMapper.emptyTypeMap(Docente.class, DocenteEntity.class);
      docenteMap2.addMapping(Docente::getObjTelefono, DocenteEntity::setObjTelefono).implicitMappings();
      
      return objMapper;
      }

      
}
