package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.TelefonoEntity;

public interface TelefonoRepositoryInt extends CrudRepository<TelefonoEntity, Integer> {

}
