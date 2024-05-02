package nova.it.model.service;

import nova.it.common.dto.AreaDTO;
import nova.it.common.dto.AreaReportesDTO;
import nova.it.common.service.AreaService;
import nova.it.model.mapper.AreaMapper;
import nova.it.model.projection.AreaInfo;
import nova.it.model.projection.AreaReportesInfo;
import nova.it.model.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    private final AreaRepository areaRepository;
    private final AreaMapper areaMapper;

    @Autowired
    public AreaServiceImpl(AreaRepository areaRepository, AreaMapper areaMapper) {
        this.areaRepository = areaRepository;
        this.areaMapper = areaMapper;
    }

    @Override
    public List<AreaDTO> obtenerAreas() {
        return areaMapper.toDTO(areaRepository.findAll(AreaInfo.class));
    }

    @Override
    public List<AreaReportesDTO> obtenerAreasReportes() {
        return areaMapper.toReportesDTO(areaRepository.findAll(AreaReportesInfo.class));
    }
}
