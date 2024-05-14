package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarCuestionario.DTOPeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarCuestionario.mappers.CuestionarioMapperInfraestructuraDominio;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.mappers.DocenteMapperInfraestructuraDominio;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.DTOPeticion.PeticionDTO;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.DTORespuesta.PeticionDTORespuesta;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.DTORespuesta.RespuestaDTORespuesta;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.mappers.PeticionMapperInfraestructuraDominio;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarRespuesta.mappers.RespuestaMapperInfraestructuraDominio;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.input.GestionarRespuestaCUIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Peticion;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Respuesta;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class RespuestaRestController {

    private final GestionarRespuestaCUIntPort objGestionarRespuestaCUInt;
    private final CuestionarioMapperInfraestructuraDominio objMapperCuestionario;
    private final DocenteMapperInfraestructuraDominio objMapperDocente;
    private final PeticionMapperInfraestructuraDominio objMapperPeticion;
    private final RespuestaMapperInfraestructuraDominio objMapperRespuesta;

    @PostMapping("/respuesta")
    public ResponseEntity<List<RespuestaDTORespuesta>> create(@Valid @RequestBody PeticionDTO objPeticion) {
        Peticion objPeticionCrear = objMapperPeticion.mapearDePeticionDTOAPeticion(objPeticion);
        List<Respuesta> objRespuestasCreadas = objGestionarRespuestaCUInt.registrarRespuestaCuestionario(objPeticionCrear);
        ResponseEntity<List<RespuestaDTORespuesta>> objRespuesta = new ResponseEntity<List<RespuestaDTORespuesta>>(
            objMapperRespuesta.mapearDeRespuestaARespuesta(objRespuestasCreadas), HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/respuestasCuestionario")
    public ResponseEntity<PeticionDTORespuesta> listar(@RequestParam CuestionarioDTOPeticion cuestionario, @RequestParam DocenteDTOPeticion docente) {
        ResponseEntity<PeticionDTORespuesta> objPeticion = new ResponseEntity<PeticionDTORespuesta>(
                objMapperPeticion.mapearDePeticionARespuesta(this.objGestionarRespuestaCUInt.consultarRespuestaDocente(objMapperCuestionario.mappearDePeticionACuestionario(cuestionario), objMapperDocente.mapearDePeticionADocente(docente))),
                HttpStatus.OK);
        return objPeticion;
    }
    
}

