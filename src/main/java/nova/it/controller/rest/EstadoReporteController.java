package nova.it.controller.rest;

import nova.it.common.dto.EstadoReporteDTO;
import nova.it.common.service.EstadoReporteService;
import nova.it.common.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("estado")
public class EstadoReporteController {
    private final EstadoReporteService estadoService;

    @Autowired
    public EstadoReporteController(EstadoReporteService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping("obtener")
    public ResponseEntity<RestResponse> obtenerEstados() {
        List<EstadoReporteDTO> estados = estadoService.obtenerEstados();
        if (estados.isEmpty()) {
            return ResponseEntity.ok(RestResponse.builder().data(estados).message("Sin resultados").status(200).build());
        } else {
            return ResponseEntity.ok(RestResponse.builder().data(estados).status(200).build());
        }
    }

}
