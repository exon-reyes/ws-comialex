package nova.it.model.projection;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

/**
 * Projection for {@link nova.it.model.entity.Ticket}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface TicketGeneralInfo {

    Integer getId();

    String getUnidadClave();

    String getUnidadNombre();

    String getReporteAreaNombre();

    String getReporteNombre();

    String getEstadoNombre();

    String getFolio();

    LocalDateTime getFecha();

    Boolean getVisible();
}