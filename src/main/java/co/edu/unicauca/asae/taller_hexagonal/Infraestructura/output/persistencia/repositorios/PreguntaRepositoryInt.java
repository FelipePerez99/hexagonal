package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.PreguntaEntity;

public interface PreguntaRepositoryInt extends CrudRepository<PreguntaEntity, Integer> {
    
}
