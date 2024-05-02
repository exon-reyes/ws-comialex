package nova.it.model.mapper;

import nova.it.common.dto.UnidadDTO;
import nova.it.model.projection.UnidadInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UnidadMapper {
    List<UnidadDTO> toDTOs(List<UnidadInfo> entities);

}