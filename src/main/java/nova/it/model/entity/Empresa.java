package nova.it.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "empresa", schema = "nova")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "razon_social", nullable = false, length = 50)
    private String razonSocial;

    @Column(name = "rfc", nullable = false)
    private String rfc;

}