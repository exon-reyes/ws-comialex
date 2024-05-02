package nova.it.model.repository;

import nova.it.model.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Integer> {
    @Query("select a from Area a")
    <T> List<T> findAll(Class<T> type);
}