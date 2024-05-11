package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios.CuestionarioRepositoryInt;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios.TipoPreguntaRepositoryInt;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;

@Service
public class GestionarCuestionarioGatewayImplAdapter implements GestionarCuestionarioGatewayIntPort  {

    private final CuestionarioRepositoryInt objCuestionarioRepository;
    private final TipoPreguntaRepositoryInt objTipoPreguntaRepository;
    private final ModelMapper cuestionarioModelMapper;

    
    public GestionarCuestionarioGatewayImplAdapter(CuestionarioRepositoryInt objCuestionarioRepository,
        ModelMapper cuestionarioModelMapper, TipoPreguntaRepositoryInt objTipoPreguntaRepository) {
        this.objCuestionarioRepository = objCuestionarioRepository;
        this.cuestionarioModelMapper = cuestionarioModelMapper;
        this.objTipoPreguntaRepository = objTipoPreguntaRepository;
    }

    @Override
    public Cuestionario guardar(Cuestionario objCuestionario) {
        CuestionarioEntity objCuestionarioEntity = this.cuestionarioModelMapper.map(objCuestionario, CuestionarioEntity.class);
        objCuestionarioEntity.setPreguntas(enlazarPreguntaCuestionario(objCuestionarioEntity.getPreguntas(), objCuestionarioEntity)); 
        //objCuestionarioEntity.getPreguntas().get(0).setObjCuestionario(objCuestionarioEntity);
        //objCuestionarioEntity.getPreguntas().get(1).setObjCuestionario(null);
        CuestionarioEntity objCuestionarioRegistrado = this.objCuestionarioRepository.save(objCuestionarioEntity);
        Cuestionario objCuestionarioRespuesta = this.cuestionarioModelMapper.map(objCuestionarioRegistrado, Cuestionario.class);
        return objCuestionarioRespuesta;
        //List<PreguntaEntity> preguntasEntity = new ArrayList<>();
        //objCuestionarioEntity.setPreguntas(preguntasEntity);
    }

    @Override
    public List<Cuestionario> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public boolean existeCuestionarioPorTitulo(String titulo) {
        return this.objCuestionarioRepository.existeCuestionarioPorTitulo(titulo) == 1;
    }

    private List<PreguntaEntity> enlazarPreguntaCuestionario(List<PreguntaEntity> preguntas, CuestionarioEntity cuestionarioEntity){
        for (PreguntaEntity preguntaEntity : preguntas) {
            preguntaEntity.setObjCuestionario(cuestionarioEntity);
        }
        return preguntas;
    }
    
}
