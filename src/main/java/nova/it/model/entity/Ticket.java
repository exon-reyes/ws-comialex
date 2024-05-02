package nova.it.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ticket", schema = "nova")
public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_unidad", nullable = false)
    private Unidad unidad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reporte", nullable = false)
    private Reporte reporte;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private EstadoReporte estado;

    @Column(name = "folio", nullable = false, length = 50)

    private String folio;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "agente", length = 50)
    private String agente;

    @Lob
    @Column(name = "nota")
    private String nota;

    @Column(name = "visible")
    private Boolean visible;

    public Ticket(Integer id) {
        this.id = id;
    }

    public Ticket() {
    }
}