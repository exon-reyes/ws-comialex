package nova.it.model.mapper;

import nova.it.common.dto.SeguimientoDTO;
import nova.it.model.entity.Seguimiento;
import nova.it.model.projection.SeguimientoInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SeguimientoMapper {

    List<SeguimientoDTO> toDTO(List<SeguimientoInfo> seguimiento);


    SeguimientoDTO toDTO(Seguimiento seguimiento);
}