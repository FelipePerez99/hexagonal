package co.edu.unicauca.asae.taller_hexagonal.Infraestructura.output.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Telefonos")
public class TelefonoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTelefono;

    @Column(nullable = false, length = 20)
    private String tipoTelefono;

    @Column(unique = true, nullable = false, length = 20)
    private String numero;

    @OneToOne
    @JoinColumn(name = "idPregunta")
    private DocenteEntity objDocente;

}
