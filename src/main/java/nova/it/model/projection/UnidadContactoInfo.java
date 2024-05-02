package nova.it.model.projection;

/**
 * Projection for {@link nova.it.model.entity.Unidad}
 */
public interface UnidadContactoInfo extends UnidadInfo {

    String getUnidadContactoTelefono();

    String getUnidadContactoDireccion();
}