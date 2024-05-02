package nova.it.model.service;

import nova.it.common.dto.EstadoReporteDTO;
import nova.it.common.service.EstadoReporteService;
import nova.it.model.mapper.EstadoReporteMapper;
import nova.it.model.repository.EstadoReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoReporteServiceImpl implements EstadoReporteService {
    private final EstadoReporteRepository repository;
    private final EstadoReporteMapper mapper;

    @Autowired
    public EstadoReporteServiceImpl(EstadoReporteRepository repository, EstadoReporteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<EstadoReporteDTO> obtenerEstados() {
        return mapper.toDTO(repository.findAll());

    }
}
