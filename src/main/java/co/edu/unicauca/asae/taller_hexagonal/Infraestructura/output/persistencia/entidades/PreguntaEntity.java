package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Preguntas")
public class PreguntaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPregunta;

    @Column(nullable = false, length = 256)
    private String enunciado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCuestionario")
    private CuestionarioEntity objCuestionario;

    @OneToMany(mappedBy = "objPregunta")
    private List<RespuestaEntity> respuestas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoPregunta")
    private TipoPreguntaEntity objTipoPregunta;
}