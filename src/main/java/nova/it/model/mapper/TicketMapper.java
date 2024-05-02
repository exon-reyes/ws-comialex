package nova.it.model.mapper;

import nova.it.common.dto.TicketDTO;
import nova.it.model.entity.Ticket;
import nova.it.model.projection.TicketDetallesInfo;
import nova.it.model.projection.TicketGeneralInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketMapper {
    TicketDTO toDTO(TicketGeneralInfo ticket);


    TicketDTO toDTO(TicketDetallesInfo ticket);


    List<TicketDTO> toDTO(List<TicketGeneralInfo> ticket);

    @Mappings({@Mapping(source = "reporte.id", target = "reporteId"), @Mapping(source = "estado.id", target = "estadoId")})
    TicketDTO toDTO(Ticket ticket);
}