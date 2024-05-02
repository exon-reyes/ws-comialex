package nova.it.model.projection;

import java.time.LocalDateTime;

/**
 * Projection for {@link nova.it.model.entity.Seguimiento}
 */
public interface SeguimientoInfo {
    Integer getId();

    String getAgente();

    LocalDateTime getFecha();

    String getNota();

    String getEstadoNombre();
}