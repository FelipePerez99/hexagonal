package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.DepartamentoEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios.DepartamentoRepositoryInt;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios.DocenteRepositoryInt;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;

@Service
public class GestionarDocenteGatewayImplAdapter implements GestionarDocenteGatewayIntPort {

    private final DocenteRepositoryInt objDocenteRepository;
    private final DepartamentoRepositoryInt objDepartamentoRepository;
    private final ModelMapper docenteModelMapper;

    public GestionarDocenteGatewayImplAdapter(DocenteRepositoryInt objDocenteRepository, DepartamentoRepositoryInt objDepartamentoRepository,
            @Qualifier("docenteMapper") ModelMapper docenteModelMapper) {
        this.objDocenteRepository = objDocenteRepository;
        this.docenteModelMapper = docenteModelMapper;
        this.objDepartamentoRepository = objDepartamentoRepository;
    }

    @Override
    public Docente guardar(Docente objDocente) {
        DocenteEntity objDocenteEntity = this.docenteModelMapper.map(objDocente, DocenteEntity.class);
        objDocenteEntity.getObjTelefono().setObjDocente(objDocenteEntity);
        objDocenteEntity.setDepartamentos(consultarDepartamentos(objDocenteEntity.getDepartamentos()));
        Docente objDocenteRespuesta = null;
        if (objDocenteEntity.getObjTelefono().getNumero() != null
                && objDocenteEntity.getObjTelefono().getTipoTelefono() != null) {
            System.out.println(objDocenteEntity.getObjTelefono().getNumero());
            DocenteEntity objDocenteEntityRegistrado = this.objDocenteRepository.save(objDocenteEntity);
            objDocenteRespuesta = this.docenteModelMapper.map(objDocenteEntityRegistrado, Docente.class);
        }

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

    private List<DepartamentoEntity> consultarDepartamentos(List<DepartamentoEntity> departamentos){
        List<DepartamentoEntity> departamentosResultado = new ArrayList<>();
        for(DepartamentoEntity departamento : departamentos){
            Optional<DepartamentoEntity> resultadoBusqueda = objDepartamentoRepository.findById(departamento.getIdDepartamento());
            if(!resultadoBusqueda.isEmpty()){
                departamentosResultado.add(resultadoBusqueda.get());
            }
        }
        return departamentosResultado;
    }

}
