package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios.CuestionarioRepositoryInt;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;

public class GestionarCuestionarioGatewayImplAdapter implements GestionarCuestionarioGatewayIntPort  {

    private final CuestionarioRepositoryInt objCuestionarioRepository;
    private final ModelMapper cuestionarioModelMapper;

    
    public GestionarCuestionarioGatewayImplAdapter(CuestionarioRepositoryInt objCuestionarioRepository,
        ModelMapper cuestionarioModelMapper) {
        this.objCuestionarioRepository = objCuestionarioRepository;
        this.cuestionarioModelMapper = cuestionarioModelMapper;
    }

    @Override
    public Cuestionario guardar(Cuestionario objCuestionario) {
        CuestionarioEntity objCuestionarioEntity = this.cuestionarioModelMapper.map(objCuestionario, CuestionarioEntity.class);
        //List<PreguntaEntity> preguntasEntity = new ArrayList<>() ;
        //objCuestionarioEntity.setPreguntas(preguntasEntity);
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public List<Cuestionario> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public boolean existeCuestionarioPorTitulo(String titulo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existeCuestionarioPorTitulo'");
    }
    
}
