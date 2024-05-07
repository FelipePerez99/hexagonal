package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Docentes")
public class DocenteEntity extends PersonaEntity {
    @Column(unique = true, nullable = false, length = 100)
    private String correo;

    @Column(nullable = false, length = 50)
    private String vinculacion;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "objDocente")
    private TelefonoEntity objTelefono;


    @OneToMany(mappedBy = "objDocente")
    private List<RespuestaEntity> respuestas;


    @ManyToMany()
    @JoinTable(name = "Departamentos-Docentes", joinColumns = @JoinColumn(name = "idPersona"), //La anotación ManyToMany se debe realizar aquí o en departamento?
    inverseJoinColumns = @JoinColumn(name = "idDepartamento"))
    private List<DepartamentoEntity> departamentos;

    public DocenteEntity() {
        super();
    }

    public DocenteEntity(String tipoIdentificacion, String numeroIdentificacion, String nombres,
        String apellidos, String correo, String vinculacion) {

        super(tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
       
    }  
}
