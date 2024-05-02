package nova.it.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estado_reporte", schema = "nova")
public class EstadoReporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;


    public EstadoReporte(Integer id) {
        this.id = id;
    }

    public EstadoReporte() {

    }
}