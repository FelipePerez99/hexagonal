package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asae.taller_hexagonal.Infraestructura.input.controllerGestionarDocente.mappers.DocenteMapperInfraestructuraDominio;
import co.edu.unicauca.asae.taller_hexagonal.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asae.taller_hexagonal.dominio.casosDeUso.GestionarDocenteCUAdapter;
import co.edu.unicauca.asae.taller_hexagonal.dominio.modelos.Docente;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Validated
public class DocenteRestController {

    private final GestionarDocenteCUIntPort objGestionarDocenteCUInt;
    private final DocenteMapperInfraestructuraDominio objMapperDocente;

    @PostMapping("/docentes")
    public ResponseEntity<DocenteDTORespuesta> create(@Valid @RequestBody DocenteDTOPeticion objDocente) {

        Docente objDocenteCrear = objMapperDocente.mapearDePeticionADocente(objDocente);
        Docente objDocenteCreado = objGestionarDocenteCUInt.registrar(objDocenteCrear);
        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<DocenteDTORespuesta>(
                objMapperDocente.mapearDeDocenteARespuesta(objDocenteCreado), HttpStatus.CREATED);
        return objRespuesta;
    }

    @GetMapping("/docentes")
    public ResponseEntity<List<DocenteDTORespuesta>> listar() {
        ResponseEntity<List<DocenteDTORespuesta>> objRespuesta = new ResponseEntity<List<DocenteDTORespuesta>>(
                objMapperDocente.mapearDeDocentesARespuesta(this.objGestionarDocenteCUInt.listar()),
                HttpStatus.OK);
        return objRespuesta;
    }
    
}
