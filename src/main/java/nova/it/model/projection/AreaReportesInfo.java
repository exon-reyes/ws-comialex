package nova.it.model.projection;

import java.util.Set;

/**
 * Projection for {@link nova.it.model.entity.Area}
 */
public interface AreaReportesInfo {
    Integer getId();

    String getNombre();

    Set<ReporteInfo> getReportes();

    /**
     * Projection for {@link nova.it.model.entity.Reporte}
     */
    interface ReporteInfo {
        Integer getId();

        String getNombre();
    }
}