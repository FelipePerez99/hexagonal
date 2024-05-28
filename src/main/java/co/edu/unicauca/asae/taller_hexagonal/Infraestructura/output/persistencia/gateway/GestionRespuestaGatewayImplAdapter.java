package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.PeticionEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.PreguntaEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades.RespuestaEntity;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios.CuestionarioRepositoryInt;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios.DocenteRepositoryInt;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.repositorios.RespuestaRepositoryInt;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.output.GestionarRespuestaGatewayIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Cuestionario;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Peticion;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Pregunta;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Respuesta;

@Service
public class GestionRespuestaGatewayImplAdapter implements GestionarRespuestaGatewayIntPort {

    private final RespuestaRepositoryInt objRespuestaRepository;
    private final DocenteRepositoryInt objDocenteRepository;
    private final CuestionarioRepositoryInt objCuestionarioRepository;
    private final ModelMapper respuestaModelMapper;
    private final ModelMapper docenteModelMapper;
    private final ModelMapper cuestionarioModelMapper;

    public GestionRespuestaGatewayImplAdapter(RespuestaRepositoryInt objRespuestaRepository,
            DocenteRepositoryInt objDocenteRepository,
            CuestionarioRepositoryInt objCuestionarioRepository,
            @Qualifier("respuestaMapper") ModelMapper respuestaModelMapper,
            @Qualifier("docenteMapper") ModelMapper docenteModelMapper,
            @Qualifier("cuestionarioMapper") ModelMapper cuestionarioModelMapper) {
        this.objRespuestaRepository = objRespuestaRepository;
        this.objDocenteRepository = objDocenteRepository;
        this.objCuestionarioRepository = objCuestionarioRepository;
        this.respuestaModelMapper = respuestaModelMapper;
        this.docenteModelMapper = docenteModelMapper;
        this.cuestionarioModelMapper = cuestionarioModelMapper;
    }

    @Override
    public List<Respuesta> guardar(Peticion objPeticion) {
        DocenteEntity objDocenteEntity = this.docenteModelMapper.map(objPeticion.getDocente(), DocenteEntity.class);
        CuestionarioEntity objCuestionarioEntity = this.cuestionarioModelMapper.map(objPeticion.getCuestionario(),
                CuestionarioEntity.class);
        List<PreguntaEntity> preguntasEntity = objCuestionarioRepository.findById(objCuestionarioEntity.getIdCuestionario()).get().getPreguntas();
        List<RespuestaEntity> respuestasEntity = mapearRespuestasARespuestasEntity(
                obtenerRespuestas(objPeticion.getListaPreguntas()));
        respuestasEntity = setDocenteAndPreguntaInRespuesta(respuestasEntity,objPeticion.getDocente(), preguntasEntity);
        objDocenteEntity.setRespuestas(respuestasEntity);
        List<Respuesta> respuestasResponse = new ArrayList<>();
        for (RespuestaEntity respuesta : respuestasEntity) {
            RespuestaEntity respuestaEntityResponse = objRespuestaRepository.save(respuesta);
            Respuesta objRespuestaResponse = respuestaModelMapper.map(respuestaEntityResponse, Respuesta.class);
            respuestasResponse.add(objRespuestaResponse);
        }
        return respuestasResponse;
    }

    

    @Override
    public List<Peticion> listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    @Override
    public Peticion respuestaCuestionarioPorProfesor(Cuestionario cuestionario, String idDocente) {
        System.out.println("----------consulta cuestionario------------");
        Optional<CuestionarioEntity> objCuestionario = objCuestionarioRepository.findById(cuestionario.getIdCuestionario());
        
        System.out.println("----------------------");
        for (PreguntaEntity pregunta : objCuestionario.get().getPreguntas()) {
            System.out.println("----------------------");
            for (RespuestaEntity respuesta : pregunta.getRespuestas()) {
                if(respuesta.getObjDocente().getIdPersona() == Integer.parseInt(idDocente)){
                    List<RespuestaEntity> listRespuesta = new ArrayList<>();
                    listRespuesta.add(respuesta);
                    pregunta.setRespuestas(listRespuesta);
                }
            }
        }
        PeticionEntity peticion = new PeticionEntity(objDocenteRepository.findById(Integer.parseInt(idDocente)).get(), objCuestionario.get(), null);
        /*Peticion peticionRespuesta = new Peticion(
            docenteModelMapper.map(objDocenteRepository.findById(Integer.parseInt(idDocente)).get(),Docente.class),
            cuestionarioModelMapper.map(objCuestionario.get(), Cuestionario.class),
            null
        );*/
        Peticion peticionRespuesta = respuestaModelMapper.map(peticion, Peticion.class);
        return peticionRespuesta;
    }

    @Override
    public boolean respuestaMismoCuestionario(Cuestionario cuestionario, Docente docente) {
        if(objRespuestaRepository.docenteYaRespondioCuestionario(docente.getIdPersona(), cuestionario.getIdCuestionario()) != 0){
            return true;
        }
        return false;
    }

    private List<RespuestaEntity> mapearRespuestasARespuestasEntity(List<Respuesta> respuestas) {
        List<RespuestaEntity> respuestasEntity = new ArrayList<>();
        for (Respuesta respuesta : respuestas) {
            RespuestaEntity respuestaReponse = this.respuestaModelMapper.map(respuesta, RespuestaEntity.class);
            respuestasEntity.add(respuestaReponse);
        }
        return respuestasEntity;
    }

    
    private List<RespuestaEntity> setDocenteAndPreguntaInRespuesta(List<RespuestaEntity> respuestas, Docente docente, List<PreguntaEntity> preguntasEntity) {
        List<RespuestaEntity> respuestasEntity = new ArrayList<>();
        Optional<DocenteEntity> docenteEntity = objDocenteRepository.findById(docente.getIdPersona());
        
        for (RespuestaEntity respuestaEntity : respuestas) {
                int bandera = 0;
            for(PreguntaEntity pregunta : preguntasEntity) {
                System.out.println(bandera);
                bandera++;
                if (pregunta.getIdPregunta() == respuestaEntity.getObjPregunta().getIdPregunta()) {
                    respuestaEntity.setObjPregunta(pregunta);
                    break;
                }
            }
            respuestaEntity.setObjDocente(docenteEntity.get());
            respuestasEntity.add(respuestaEntity);
            
        }

        return respuestasEntity;
    }

    private List<Respuesta> obtenerRespuestas(List<Pregunta> preguntas) {
        List<Respuesta> respuestas = new ArrayList<>();
        for (Pregunta pregunta : preguntas) {
            Respuesta respuesta = pregunta.getRespuestas().get(0);
            respuesta.setObjPregunta(pregunta);
            respuestas.add(respuesta);
        }
        return respuestas;
    }
}
