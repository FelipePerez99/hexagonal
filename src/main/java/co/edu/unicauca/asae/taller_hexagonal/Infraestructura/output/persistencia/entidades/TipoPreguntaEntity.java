package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TipoPreguntas")
public class TipoPreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoPregunta;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 256)
    private String descripcion;

    @OneToMany(mappedBy = "objTipoPregunta")
    private List<PreguntaEntity> preguntas;

    

}
