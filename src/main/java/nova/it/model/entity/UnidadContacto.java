package nova.it.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "unidad_contacto", schema = "nova")
public class UnidadContacto {
    @Id
    @Column(name = "id_unidad", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_unidad", nullable = false)
    private Unidad unidad;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

}