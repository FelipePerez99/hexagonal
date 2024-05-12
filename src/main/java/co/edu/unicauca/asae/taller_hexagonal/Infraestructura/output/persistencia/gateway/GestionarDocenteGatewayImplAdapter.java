package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios.DocenteRepositoryInt;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;

public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort{

    private final DocenteRepositoryInt objDocenteRepository;
    private final ModelMapper docenteModelMapper;

    

    public GestionarDocenteGatewayImplAdapter(DocenteRepositoryInt objDocenteRepository,
            ModelMapper docenteModelMapper) {
        this.objDocenteRepository = objDocenteRepository;
        this.docenteModelMapper = docenteModelMapper;
    }

    @Override
    public Docente guardar(Docente objDocente) {
         DocenteEntity objDocenteEntity = this.docenteModelMapper.map(objDocente, DocenteEntity.class);
        //objDocenteEntity.getObjDireccion().setObjPersona(objDocenteEntity);
        DocenteEntity objDocenteEntityRegistrado = this.objDocenteRepository.save(objDocenteEntity);
        Docente objDocenteRespuesta = this.docenteModelMapper.map(objDocenteEntityRegistrado, Docente.class);
        return objDocenteRespuesta;
    }

    @Override
    public List<Docente> listar() {
        Iterable<DocenteEntity> lista = this.objDocenteRepository.findAll();
        List<Docente> listaObtenida = this.docenteModelMapper.map(lista, new TypeToken<List<Docente>>() {
        }.getType());
        return listaObtenida;
    }

    @Override
    public boolean existeDocentePorCorreo(String correo) {
        return this.objDocenteRepository.existeDocentePorCorreo(correo) == 1;
    }

    @Override
    public boolean existeDocentePorIdentificacion(String identificacion) {
        return this.objDocenteRepository.existeDocentePorIdentificacion(identificacion) == 1;
    }
    
}
