package nova.it.model.service;

import nova.it.common.dto.TicketDTO;
import nova.it.common.exception.TicketException;
import nova.it.common.service.SeguimientoService;
import nova.it.common.service.TicketService;
import nova.it.common.util.TicketParams;
import nova.it.model.entity.EstadoReporte;
import nova.it.model.entity.Reporte;
import nova.it.model.entity.Ticket;
import nova.it.model.entity.Unidad;
import nova.it.model.mapper.TicketMapper;
import nova.it.model.projection.TicketDetallesInfo;
import nova.it.model.projection.TicketGeneralInfo;
import nova.it.model.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    private final TicketRepository repository;
    private final SeguimientoService seguimientoService;

    private final TicketMapper mapper;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, SeguimientoService seguimientoService, TicketMapper mapper) {
        this.repository = ticketRepository;
        this.seguimientoService = seguimientoService;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<TicketDTO> obtenerGenerales(String folio) {
        Optional<TicketDTO> result;
        TicketGeneralInfo info = repository.obtenerGenerales(folio);
        if (info != null) {
            result = Optional.of(mapper.toDTO(info));
        } else {
            result = Optional.empty();
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TicketDTO> obtenerDetalles(String folio) {
        Optional<TicketDTO> result;
        TicketDetallesInfo info = repository.obtenerDetalles(folio);
        if (info != null) {
            result = Optional.of(mapper.toDTO(info));
        } else {
            result = Optional.empty();
        }
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> obtenerTickets(TicketParams filtro) {
        Pageable pageable = PageRequest.of(filtro.getPagina(), filtro.getFilas(), Sort.by("fecha").descending());
        Page<TicketGeneralInfo> pageResult = repository.obtenerTickets(filtro.getIdEstado(), filtro.getIdUnidad(), filtro.getIdArea(), filtro.getFecha(), pageable);
        Map<String, Object> result = new HashMap<String, Object>();

        List<TicketDTO> dtoList = mapper.toDTO(pageResult.getContent());
        if (!dtoList.isEmpty()) {
            result.put("tickets", dtoList);
            result.put("totalElementos", pageResult.getTotalElements());
            result.put("totalPagina", pageResult.getTotalPages());
            result.put("numero", pageResult.getNumber());
            result.put("numeroElementos", pageResult.getNumberOfElements());
            result.put("total", dtoList.size());
            return result;
        }
        return result;
    }

    @Override
    public boolean existeFolio(String folio) {
        return repository.existsByFolioAndVisible(folio, true);
    }

    @Override
    public Optional<TicketDTO> crear(TicketDTO dto) {
        if (existeFolio(dto.getFolio())) {
            throw new TicketException("Ya existe un ticket con el folio " + dto.getFolio(), null, HttpStatus.CONFLICT.value());
        }
        Optional<TicketDTO> optional;
        Ticket data = new Ticket();
        data.setFolio(dto.getFolio());
        data.setFecha(LocalDateTime.now());
        data.setAgente(dto.getAgente());
        data.setNota(dto.getNota());
        data.setVisible(true);
        data.setUnidad(new Unidad(dto.getUnidadId()));
        data.setReporte(new Reporte(dto.getReporteId()));
        data.setEstado(new EstadoReporte(dto.getEstadoId() == null ? 2 : dto.getEstadoId()));

        data = repository.save(data);
        optional = Optional.of(mapper.toDTO(data));
        //Registramos en la tabla seguimiento la información del ticket
        seguimientoService.registrar(seguimientoService.construir(optional.get(), "Se ha creado el ticket"));

        return optional;
    }

    @Override
    public Optional<TicketDTO> actualizar(TicketDTO newDataDTO) {
        // Obtenemos el ticket con los últimos datos
        Ticket current = repository.findById(newDataDTO.getId()).orElseThrow(() -> new TicketException("El ticket no existe", null, HttpStatus.NOT_FOUND.value()));
        if (!current.getVisible()) {
            throw new TicketException("El ticket ya no se encuentra disponible", null, HttpStatus.NOT_FOUND.value());
        }

        if (newDataDTO.getAgente() != null) {
            current.setAgente(newDataDTO.getAgente());
        }

        if (newDataDTO.getNota() != null) {
            current.setNota(newDataDTO.getNota());
        }

        if (newDataDTO.getUnidadId() != null) {
            current.setUnidad(new Unidad(newDataDTO.getUnidadId()));
        }

        // Actualizar solo las propiedades modificadas
        Ticket newData = repository.save(current);

        seguimientoService.registrar(seguimientoService.construir(mapper.toDTO(newData), "Se ha actualizado el ticket"));
        return Optional.of(mapper.toDTO(newData));
    }

}

