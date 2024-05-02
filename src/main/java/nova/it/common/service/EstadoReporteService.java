package nova.it.common.service;

import nova.it.common.dto.EstadoReporteDTO;

import java.util.List;

public interface EstadoReporteService {
    List<EstadoReporteDTO> obtenerEstados();
}
