package nova.it.model.repository;

import nova.it.model.entity.Seguimiento;
import nova.it.model.projection.SeguimientoInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento, Integer> {
    List<SeguimientoInfo> findByTicket_Id(Integer id);


}