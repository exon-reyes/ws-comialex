package nova.it.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link nova.it.model.entity.Area}
 */
@AllArgsConstructor
@Getter
public class AreaReportesDTO implements Serializable {
    private final Integer id;
    private final String nombre;
    private final Set<ReporteDTO> reportes;

    /**
     * DTO for {@link nova.it.model.entity.Reporte}
     */
    @Value
    public static class ReporteDTO implements Serializable {
        Integer id;
        String nombre;
    }
}