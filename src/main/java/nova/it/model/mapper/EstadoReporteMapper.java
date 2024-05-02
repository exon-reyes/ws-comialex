package nova.it.model.mapper;

import nova.it.common.dto.EstadoReporteDTO;
import nova.it.model.entity.EstadoReporte;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EstadoReporteMapper {


    List<EstadoReporteDTO> toDTO(List<EstadoReporte> estadoReporte);
}