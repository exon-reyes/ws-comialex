package nova.it.controller.rest;

import nova.it.common.dto.AreaDTO;
import nova.it.common.dto.AreaReportesDTO;
import nova.it.common.service.AreaService;
import nova.it.common.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("area")
public class AreaController {
    private final AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping("areas")
    public ResponseEntity<RestResponse> obtenerAreas() {
        List<AreaDTO> areaDTOS = areaService.obtenerAreas();
        if (areaDTOS.isEmpty()) {
            return ResponseEntity.ok(RestResponse.builder().message("No existen areas").status(HttpStatus.NO_CONTENT.value()).build());
        } else {
            return ResponseEntity.ok(RestResponse.builder().data(areaDTOS).status(HttpStatus.OK.value()).build());
        }
    }

    @GetMapping("area-reportes")
    public ResponseEntity<RestResponse> obtenerConReportes() {
        List<AreaReportesDTO> r = areaService.obtenerAreasReportes();
        if (r.isEmpty()) {
            return ResponseEntity.ok(RestResponse.builder().message("Sin resultados").data(r).status(HttpStatus.NO_CONTENT.value()).build());
        } else {
            return ResponseEntity.ok(RestResponse.builder().data(r).status(HttpStatus.OK.value()).build());
        }
    }
}