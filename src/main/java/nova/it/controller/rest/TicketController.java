package nova.it.controller.rest;

import jakarta.validation.Valid;
import nova.it.common.dto.TicketDTO;
import nova.it.common.service.TicketService;
import nova.it.common.util.RestResponse;
import nova.it.common.util.TicketParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("ticket")
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @RequestMapping("/general/folio")
    public ResponseEntity<RestResponse> obtenerGenerales(@RequestParam("folio") String folio) {
        Optional<TicketDTO> dto = ticketService.obtenerGenerales(folio);
        if (dto.isPresent()) {
            return ResponseEntity.ok(RestResponse.builder().data(dto.get()).build());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el ticket especificado");
        }
    }

    @RequestMapping("/detalles/folio")
    public ResponseEntity<RestResponse> obtenerDetalles(@RequestParam("folio") String folio) {
        Optional<TicketDTO> dto = ticketService.obtenerDetalles(folio);
        if (dto.isPresent()) {
            return ResponseEntity.ok(RestResponse.builder().data(dto.get()).build());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encuentra el ticket especificado");
        }
    }

    @GetMapping("tickets")
    public ResponseEntity<RestResponse> obtenerTickets(@RequestParam("fecha") LocalDateTime fecha, @RequestParam("pagina") int pagina, @RequestParam("filas") int filas, @RequestParam(value = "unidadId", required = false) Integer unidadId, @RequestParam(value = "idEstado", required = false) Integer idEstado, @RequestParam(value = "idArea", required = false) Integer idArea) {
        TicketParams params = new TicketParams(fecha, pagina, filas, unidadId, idEstado, idArea);
        Map result = ticketService.obtenerTickets(params);
        if (result.isEmpty()) {
            return ResponseEntity.ok(RestResponse.builder().message("No se encontraron resultados").status(HttpStatus.OK.value()).build());
        } else {
            return ResponseEntity.ok(RestResponse.builder().data(result).status(HttpStatus.OK.value()).build());
        }

    }

    @PostMapping("ticket")
    public ResponseEntity<RestResponse> crear(@Valid @RequestBody TicketDTO dto) {
        Optional<TicketDTO> result = ticketService.crear(dto);
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo registrar el ticket");
        } else {
            return ResponseEntity.ok(RestResponse.builder().status(HttpStatus.OK.value()).data(result.get()).message("El ticket ha sido registrado").build());
        }
    }

    @PutMapping("actualizar")
    public ResponseEntity<RestResponse> actualizar(@RequestBody TicketDTO dto) {
        if (dto.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El id del ticket actualizar es obligatorio");
        }
        Optional<TicketDTO> result = ticketService.actualizar(dto);
        if (result.isPresent()) {
            return ResponseEntity.ok(RestResponse.builder().data(result.get()).status(HttpStatus.OK.value()).message("El ticket se ha actualizado").build());
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo actualizar el ticket");
        }
    }

}
