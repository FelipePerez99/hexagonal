package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.RespuestaEntity;

public interface RespuestaRepositoryInt extends CrudRepository<RespuestaEntity, Integer> {
    @Query(value = "SELECT COUNT(*) FROM respuestas as r JOIN preguntas as p ON r.idPregunta = p.idPregunta WHERE p.idCuestionario = :idCuestionario AND r.idDocente = :idDocente", nativeQuery = true)
    Integer docenteYaRespondioCuestionario(Integer idDocente, Integer idCuestionario);
}
