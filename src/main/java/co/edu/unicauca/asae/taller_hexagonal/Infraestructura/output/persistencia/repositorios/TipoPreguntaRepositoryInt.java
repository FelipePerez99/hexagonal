package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.TipoPreguntaEntity;

public interface TipoPreguntaRepositoryInt extends CrudRepository<TipoPreguntaEntity, Integer> {
    
}
