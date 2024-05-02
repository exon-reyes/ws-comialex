package nova.it.common.service;

import nova.it.common.dto.AreaDTO;
import nova.it.common.dto.AreaReportesDTO;

import java.util.List;

public interface AreaService {
    List<AreaDTO> obtenerAreas();

    List<AreaReportesDTO> obtenerAreasReportes();
}
