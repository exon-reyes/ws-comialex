package nova.it.controller.rest;

import nova.it.common.dto.SeguimientoDTO;
import nova.it.common.service.SeguimientoService;
import nova.it.common.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("seguimiento")
public class SeguimientoController {
    private final SeguimientoService seguimientoService;

    @Autowired
    public SeguimientoController(SeguimientoService seguimientoService) {
        this.seguimientoService = seguimientoService;
    }

    @GetMapping("seguimientos")
    public ResponseEntity<RestResponse> obtenerSeguimiento(@RequestParam(name = "idTicket", required = true) Integer idTicket) {
        Optional<List<SeguimientoDTO>> result = seguimientoService.obtenerSeguimientos(idTicket);
        return result.map(dtos -> ResponseEntity.ok(RestResponse.builder().status(HttpStatus.OK.value()).data(dtos).build())).orElseGet(() -> ResponseEntity.ok(RestResponse.builder().data(new ArrayList<>()).status(HttpStatus.NOT_FOUND.value()).message("No existen seguimientos registrados").build()));
    }

    @PostMapping("seguimiento")
    public ResponseEntity<RestResponse> guardar(@RequestBody SeguimientoDTO dto) {
        SeguimientoDTO result = seguimientoService.registrar(dto);
        if (result != null) {
            return ResponseEntity.ok(RestResponse.builder().status(HttpStatus.OK.value()).data(result).build());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo guardar el seguimiento");
        }
    }
}
