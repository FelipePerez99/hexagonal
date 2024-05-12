package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.modelmapper.TypeToken;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios.CuestionarioRepositoryInt;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;

@Service
public class GestionarCuestionarioGatewayImplAdapter implements GestionarCuestionarioGatewayIntPort  {

    private final CuestionarioRepositoryInt objCuestionarioRepository;
    private final ModelMapper cuestionarioModelMapper;

    
    public GestionarCuestionarioGatewayImplAdapter(CuestionarioRepositoryInt objCuestionarioRepository,
        @Qualifier("cuestionarioMapper") ModelMapper cuestionarioModelMapper) {
        this.objCuestionarioRepository = objCuestionarioRepository;
        this.cuestionarioModelMapper = cuestionarioModelMapper;
    }

    @Override
    public Cuestionario guardar(Cuestionario objCuestionario) {
        CuestionarioEntity objCuestionarioEntity = this.cuestionarioModelMapper.map(objCuestionario, CuestionarioEntity.class);
        objCuestionarioEntity.setPreguntas(enlazarPreguntaCuestionario(objCuestionarioEntity.getPreguntas(), objCuestionarioEntity)); 
        //objCuestionarioEntity.getPreguntas().get(0).setObjCuestionario(objCuestionarioEntity);
        //objCuestionarioEntity.getPreguntas().get(1).setObjCuestionario(null);
        
        CuestionarioEntity objCuestionarioRegistrado = this.objCuestionarioRepository.save(objCuestionarioEntity);
        System.out.println("/n");
        System.out.println("/n");
        System.out.println(objCuestionarioRegistrado.getPreguntas().get(0).getEnunciado() );
        System.out.println("/n");
        System.out.println("/n");
        Cuestionario objCuestionarioRespuesta = this.cuestionarioModelMapper.map(objCuestionarioRegistrado, Cuestionario.class);
        return objCuestionarioRespuesta;
        //List<PreguntaEntity> preguntasEntity = new ArrayList<>();
        //objCuestionarioEntity.setPreguntas(preguntasEntity);
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
        }
        return preguntas;
    }
    
}
