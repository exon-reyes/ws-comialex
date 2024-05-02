package nova.it.model.service;

import nova.it.common.dto.ContactoDTO;
import nova.it.common.dto.OperatividadDTO;
import nova.it.common.dto.UnidadDTO;
import nova.it.common.exception.UnidadException;
import nova.it.common.service.UnidadService;
import nova.it.model.mapper.UnidadMapper;
import nova.it.model.projection.OperatividadInfo;
import nova.it.model.projection.UnidadContactoInfo;
import nova.it.model.repository.OperatividadRepository;
import nova.it.model.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnidadServiceImpl implements UnidadService {
    private final UnidadRepository repository;
    private final OperatividadRepository operatividadRepository;
    private final UnidadMapper mapper;

    @Autowired
    public UnidadServiceImpl(UnidadRepository repository, OperatividadRepository operatividadRepository, UnidadMapper mapper) {
        this.repository = repository;
        this.operatividadRepository = operatividadRepository;
        this.mapper = mapper;
    }

    @Override
    public List<UnidadDTO> obtenerUnidades() {
        return mapper.toDTOs(repository.obtenerUnidades());
    }

    @Override
    public UnidadDTO obtenerContacto(Integer idUnidad) {
        UnidadContactoInfo info = repository.findById(idUnidad, UnidadContactoInfo.class);
        if (info == null) {
            throw new UnidadException("Unidad no encontrada", null, 404);
        }
        UnidadDTO dto = new UnidadDTO();
        dto.setId(info.getId());
        dto.setClave(info.getClave());
        dto.setNombre(info.getNombre());
        ContactoDTO contactoDTO = new ContactoDTO();
        contactoDTO.setTelefono(info.getUnidadContactoTelefono());
        contactoDTO.setDireccion(info.getUnidadContactoDireccion());
        dto.setContacto(contactoDTO);
        return dto;
    }


    @Override
    public List<OperatividadDTO> obtenerOperatividads(Integer idUnidad) {
        List<OperatividadInfo> info = this.operatividadRepository.findByUnidad_IdAndActivoTrue(idUnidad);
        List<OperatividadDTO> newList = new ArrayList<>();
        for (OperatividadInfo dto : info) {
            OperatividadDTO operatividadDTO = new OperatividadDTO();
            operatividadDTO.setId(dto.getId());
            operatividadDTO.setHoraApertura(dto.getHoraApertura());
            operatividadDTO.setHoraCierre(dto.getHoraCierre());
            operatividadDTO.setHorarioId(dto.getHorarioId());
            operatividadDTO.setHorarioNombre(dto.getHorarioNombre());
            newList.add(operatividadDTO);
        }
        return newList;
    }
}
