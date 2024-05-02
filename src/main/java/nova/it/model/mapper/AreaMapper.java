package nova.it.model.mapper;

import nova.it.common.dto.AreaDTO;
import nova.it.common.dto.AreaReportesDTO;
import nova.it.model.projection.AreaInfo;
import nova.it.model.projection.AreaReportesInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AreaMapper {


    List<AreaDTO> toDTO(List<AreaInfo> area);

    List<AreaReportesDTO> toReportesDTO(List<AreaReportesInfo> area);
}