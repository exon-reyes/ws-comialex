package nova.it.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * DTO for {@link nova.it.model.entity.Operatividad}
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperatividadDTO implements Serializable {
    private Integer id;
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private Boolean activo;

    private Integer horarioId;
    private String horarioNombre;
}