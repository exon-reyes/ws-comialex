package nova.it.model.projection;

import java.util.Set;

/**
 * Projection for {@link nova.it.model.entity.Unidad}
 */
public interface UnidadOperatividad extends UnidadInfo {


    Set<OperatividadInfo> getOperatividads();


}