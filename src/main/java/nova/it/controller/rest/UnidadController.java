package nova.it.controller.rest;


import nova.it.common.dto.UnidadDTO;
import nova.it.common.service.UnidadService;
import nova.it.common.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("unidad")
public class UnidadController {
    private final UnidadService unidadService;

    @Autowired
    public UnidadController(UnidadService unidadService) {
        this.unidadService = unidadService;
    }

    @RequestMapping("unidades")
    public ResponseEntity<RestResponse> obtenerUnidades() {
        List<UnidadDTO> list = unidadService.obtenerUnidades();
        if (list.isEmpty()) {
            return ResponseEntity.ok(RestResponse.builder().message("No existen Unidades").status(HttpStatus.NO_CONTENT.value()).build());
        } else {
            return ResponseEntity.ok(RestResponse.builder().data(list).status(HttpStatus.OK.value()).build());
        }
    }

    @RequestMapping("contacto")
    public ResponseEntity<RestResponse> obtenerContacto(@RequestParam("idUnidad") Integer idUnidad) {
        UnidadDTO dto = unidadService.obtenerContacto(idUnidad);
        if (dto == null) {
            return ResponseEntity.ok(RestResponse.builder().message("No existen Unidades").status(HttpStatus.NO_CONTENT.value()).build());
        } else {
            return ResponseEntity.ok(RestResponse.builder().data(dto).status(HttpStatus.OK.value()).build());
        }
    }

    @RequestMapping("horario")
    public ResponseEntity<RestResponse> obtenerHorario(@RequestParam("idUnidad") Integer idUnidad) {
        UnidadDTO result = new UnidadDTO();
        result.setOperatividad(unidadService.obtenerOperatividads(idUnidad));
        return ResponseEntity.ok(RestResponse.builder().data(result).status(HttpStatus.OK.value()).build());
    }
}
