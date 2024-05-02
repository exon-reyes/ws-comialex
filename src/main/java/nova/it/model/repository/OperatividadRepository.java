package nova.it.model.repository;

import nova.it.model.entity.Operatividad;
import nova.it.model.projection.OperatividadInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperatividadRepository extends JpaRepository<Operatividad, Integer> {
    List<OperatividadInfo> findByUnidad_IdAndActivoTrue(Integer id);

}