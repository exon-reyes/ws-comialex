package nova.it.model.projection;

import java.time.LocalTime;

/**
 * Projection for {@link nova.it.model.entity.Operatividad}
 */
public interface OperatividadInfo {
    Integer getId();

    LocalTime getHoraApertura();

    LocalTime getHoraCierre();

    Boolean isActivo();

    Integer getHorarioId();

    String getHorarioNombre();
}