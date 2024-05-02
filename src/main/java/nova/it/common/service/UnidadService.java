package nova.it.common.service;

import nova.it.common.dto.UnidadDTO;

import java.util.List;

public interface UnidadService extends OperatividadService {
    List<UnidadDTO> obtenerUnidades();

    UnidadDTO obtenerContacto(Integer idUnidad);

}
