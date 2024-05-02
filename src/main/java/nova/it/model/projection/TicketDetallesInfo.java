package nova.it.model.projection;

import java.time.LocalDateTime;

/**
 * Projection for {@link nova.it.model.entity.Ticket}
 */
public interface TicketDetallesInfo {
    Integer getId();

    Integer getUnidadId();

    String getUnidadClave();

    String getUnidadNombre();

    Integer getReporteId();

    Integer getReporteAreaId();

    String getReporteAreaNombre();

    String getReporteNombre();

    Integer getEstadoId();

    String getEstadoNombre();

    String getFolio();

    LocalDateTime getFecha();

    String getAgente();

    String getNota();

    Boolean getVisible();
}