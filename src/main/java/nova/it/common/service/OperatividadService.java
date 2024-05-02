package nova.it.common.service;

import nova.it.common.dto.OperatividadDTO;

import java.util.List;

public interface OperatividadService {

    List<OperatividadDTO> obtenerOperatividads(Integer idUnidad);
}
