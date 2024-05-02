package nova.it.common.service;

import nova.it.common.dto.SeguimientoDTO;
import nova.it.common.dto.TicketDTO;

import java.util.List;
import java.util.Optional;

public interface SeguimientoService {
    SeguimientoDTO construir(TicketDTO dto, String comentario);

    SeguimientoDTO registrar(SeguimientoDTO dto);

    Optional<List<SeguimientoDTO>> obtenerSeguimientos(Integer id);
}
