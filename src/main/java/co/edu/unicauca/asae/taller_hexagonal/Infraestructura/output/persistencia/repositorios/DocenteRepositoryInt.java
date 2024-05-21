package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepositoryInt extends CrudRepository<DocenteEntity, Integer> {
    @Query("SELECT count(*) FROM DocenteEntity d WHERE d.numeroIdentificacion=:numeroIdentificacion")
    Integer existeDocentePorIdentificacion(String numeroIdentificacion);

    @Query("SELECT count(*) FROM DocenteEntity d WHERE LOWER(d.correo) = LOWER(:correo)")
    Integer existeDocentePorCorreo(String correo);
}
