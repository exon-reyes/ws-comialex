package nova.it.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "unidad", schema = "nova")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unidad", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    @Column(name = "clave", nullable = false, length = 10)
    private String clave;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @OneToOne(mappedBy = "unidad")
    private UnidadContacto unidadContacto;

    public Unidad(Integer id) {
        this.id = id;
    }

    public Unidad() {

    }

}