package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.CuestionarioEntity;

public interface CuestionarioRepositoryInt extends CrudRepository<CuestionarioEntity, Integer> {
    @Query("SELECT count(*) FROM CuestionarioEntity c  WHERE c.titulo=?1")
    Integer existeCuestionarioPorTitulo(String titulo);

    Iterable<CuestionarioEntity> findByTituloContainingIgnoreCaseOrderByIdCuestionarioDesc(String titulo);
}
