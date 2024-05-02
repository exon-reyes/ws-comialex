package nova.it.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link nova.it.model.entity.Unidad}
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UnidadDTO implements Serializable {
    private Integer id;
    private String clave;
    private String nombre;
    private ContactoDTO contacto;
    private List<OperatividadDTO> operatividad;


}
