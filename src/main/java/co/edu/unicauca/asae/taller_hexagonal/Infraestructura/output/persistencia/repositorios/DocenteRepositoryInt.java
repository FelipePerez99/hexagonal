package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.DocenteEntity;

public interface DocenteRepositoryInt extends CrudRepository<DocenteEntity, Integer> {
    @Query("SELECT count(*) FROM DocenteEntity p  WHERE p.numeroIdentificacion=?1")
    Integer existeDocentePorIdentificacion(String numeroIdentificacion);

    @Query("SELECT count(*) FROM DocenteEntity p  WHERE LOWER(p.correo) = LOWER(:correo)")
    Integer existeDocentePorCorreo(String correo);
}
