package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cuestionarios")
public class CuestionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCuestionario;

    @Column(nullable = false, length = 50)
    private String titulo;

    @Column(nullable = true, length = 256)
    private String descripcion;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},  mappedBy = "objCuestionario", fetch = FetchType.EAGER)
    private List<PreguntaEntity> preguntas;

    public void agregarPregunta(PreguntaEntity pregunta){
        this.preguntas.add(pregunta);
    }
}
