package nova.it.common.service;

import nova.it.common.dto.TicketDTO;
import nova.it.common.util.TicketParams;

import java.util.Map;
import java.util.Optional;

public interface TicketService {
    Optional<TicketDTO> obtenerGenerales(String folio);

    Optional<TicketDTO> obtenerDetalles(String folio);

    Map obtenerTickets(TicketParams params);

    boolean existeFolio(String folio);

    Optional<TicketDTO> crear(TicketDTO dto);

    Optional<TicketDTO> actualizar(TicketDTO dto);
}
