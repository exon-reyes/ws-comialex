package nova.it.model.repository;

import nova.it.model.entity.EstadoReporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoReporteRepository extends JpaRepository<EstadoReporte, Integer> {
}