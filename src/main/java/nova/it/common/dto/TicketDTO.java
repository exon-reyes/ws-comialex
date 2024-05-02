package nova.it.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link nova.it.model.entity.Ticket}
 */
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketDTO implements Serializable {
    private Integer id;
    @NotNull(message = "La unidad es requerida")
    @NotNull(message = "La unidad referenciada no puede ser un valor vacio")
    private Integer unidadId;
    private String unidadClave;
    private String unidadNombre;

    @NotNull(message = "El reporte es requerido")
    @NotNull(message = "El reporte referenciado no puede ser un valor vacio")
    private Integer reporteId;
    private Integer reporteAreaId;
    private String reporteAreaNombre;
    private String reporteNombre;
    private Integer estadoId;
    private String estadoNombre;
    @NotNull(message = "El folio es requerido")
    @NotBlank(message = "El folio no puede ser vacío")
    private String folio;
    private LocalDateTime fecha;
    private String agente;
    private String nota;
    private Boolean visible;
}