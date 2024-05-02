package nova.it.model.service;

import nova.it.common.dto.SeguimientoDTO;
import nova.it.common.dto.TicketDTO;
import nova.it.common.service.SeguimientoService;
import nova.it.model.entity.EstadoReporte;
import nova.it.model.entity.Seguimiento;
import nova.it.model.entity.Ticket;
import nova.it.model.mapper.SeguimientoMapper;
import nova.it.model.projection.SeguimientoInfo;
import nova.it.model.repository.SeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class SeguimientoServiceImpl implements SeguimientoService {
    private final SeguimientoRepository repository;
    private final SeguimientoMapper mapper;

    @Autowired
    public SeguimientoServiceImpl(SeguimientoRepository repository, SeguimientoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public SeguimientoDTO construir(TicketDTO dto, String comentario) {
        SeguimientoDTO result = new SeguimientoDTO();
        result.setTicketId(dto.getId());
        result.setEstadoId(dto.getEstadoId());
        result.setAgente("Sistema");
        result.setFecha(dto.getFecha() != null ? dto.getFecha() : LocalDateTime.now());
        result.setNota(comentario);
        return result;
    }

    @Override
    public SeguimientoDTO registrar(SeguimientoDTO dto) {
        Seguimiento data = new Seguimiento();
        if (dto.getEstadoId() != null) {
            data.setEstado(new EstadoReporte(dto.getEstadoId()));
        }
        if (dto.getNota() != null) {
            data.setNota(dto.getNota());
        }
        if (dto.getAgente() != null) {
            data.setAgente(dto.getAgente());
        }
        if (dto.getFecha() != null) {
            data.setFecha(dto.getFecha());
        } else {
            data.setFecha(LocalDateTime.now());
        }
        if (dto.getTicketId() != null) {
            data.setTicket(new Ticket(dto.getTicketId()));
        }
        Seguimiento temp = repository.save(data);
        return mapper.toDTO(temp);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional obtenerSeguimientos(Integer idTicket) {
        //Inicializamos la propiedad administrada result
        Optional<List<SeguimientoDTO>> result = Optional.empty();
        List<SeguimientoInfo> data = repository.findByTicket_Id(idTicket);
        data.sort(Comparator.comparing(SeguimientoInfo::getFecha).reversed()); // Ordenar por fecha descendente
        if (data.isEmpty()) {
            result = Optional.empty();
        } else {
            result = Optional.of(mapper.toDTO(data));
        }
        return result;

    }

}
