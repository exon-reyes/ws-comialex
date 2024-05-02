package nova.it.model.repository;

import nova.it.model.entity.Unidad;
import nova.it.model.projection.UnidadInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UnidadRepository extends JpaRepository<Unidad, Integer> {


    @Query("select u.id as id,u.clave as clave,u.nombre as nombre from Unidad u")
    List<UnidadInfo> obtenerUnidades();

    @EntityGraph(attributePaths = {"unidadContacto"}, type = EntityGraph.EntityGraphType.LOAD)
//    @Query("select u from Unidad u where u.id = ?1")
    <T> T findById(Integer idUnidad, Class<T> type);
}