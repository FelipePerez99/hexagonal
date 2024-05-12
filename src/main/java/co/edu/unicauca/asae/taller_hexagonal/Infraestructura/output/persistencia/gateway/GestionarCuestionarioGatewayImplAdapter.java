package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.gateway;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeToken;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.TipoPreguntaEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios.CuestionarioRepositoryInt;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios.TipoPreguntaRepositoryInt;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;

@Service
public class GestionarCuestionarioGatewayImplAdapter implements GestionarCuestionarioGatewayIntPort  {

    private final CuestionarioRepositoryInt objCuestionarioRepository;
    private final TipoPreguntaRepositoryInt objTipoPreguntaRepository;
    private final ModelMapper cuestionarioModelMapper;

    
    public GestionarCuestionarioGatewayImplAdapter(CuestionarioRepositoryInt objCuestionarioRepository, TipoPreguntaRepositoryInt objTipoPreguntaRepository,
        @Qualifier("cuestionarioMapper") ModelMapper cuestionarioModelMapper) {
        this.objCuestionarioRepository = objCuestionarioRepository;
        this.cuestionarioModelMapper = cuestionarioModelMapper;
        this.objTipoPreguntaRepository = objTipoPreguntaRepository;
    }

    @Override
    public Cuestionario guardar(Cuestionario objCuestionario) {
        CuestionarioEntity objCuestionarioEntity = this.cuestionarioModelMapper.map(objCuestionario, CuestionarioEntity.class);
        objCuestionarioEntity.setPreguntas(enlazarPreguntaCuestionario(objCuestionarioEntity.getPreguntas(), objCuestionarioEntity)); 
        CuestionarioEntity objCuestionarioRegistrado = this.objCuestionarioRepository.save(objCuestionarioEntity);
        Cuestionario objCuestionarioRespuesta = this.cuestionarioModelMapper.map(objCuestionarioRegistrado, Cuestionario.class);
        return objCuestionarioRespuesta;
    }

    @Override
    public List<Cuestionario> listar() {
        Iterable<CuestionarioEntity> lista = this.objCuestionarioRepository.findAll();
        List<Cuestionario> listaObtenida = this.cuestionarioModelMapper.map(lista, new TypeToken<List<Cuestionario>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public boolean existeCuestionarioPorTitulo(String titulo) {
        return this.objCuestionarioRepository.existeCuestionarioPorTitulo(titulo) == 1;
    }

    private List<PreguntaEntity> enlazarPreguntaCuestionario(List<PreguntaEntity> preguntas, CuestionarioEntity cuestionarioEntity){
        for (PreguntaEntity preguntaEntity : preguntas) {
            preguntaEntity.setObjCuestionario(cuestionarioEntity);
            preguntaEntity = enlazarPreguntaTipoPregunta(preguntaEntity);
        }
        return preguntas;
    }

    private PreguntaEntity enlazarPreguntaTipoPregunta(PreguntaEntity pregunta){
        Optional<TipoPreguntaEntity> objTipoPreguntaRespuesta = objTipoPreguntaRepository.findById(pregunta.getObjTipoPregunta().getIdTipoPregunta());
        pregunta.setObjTipoPregunta(objTipoPreguntaRespuesta.get());
        return pregunta;
    }
    
}
