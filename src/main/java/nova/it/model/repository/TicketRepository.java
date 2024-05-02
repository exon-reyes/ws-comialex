package nova.it.model.repository;

import nova.it.model.entity.Ticket;
import nova.it.model.projection.TicketDetallesInfo;
import nova.it.model.projection.TicketGeneralInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {


    @Query(value = "CALL ticket_generales(:_folio);", nativeQuery = true)
    TicketGeneralInfo obtenerGenerales(@Param("_folio") String folio);

    @Query(value = "CALL ticket_detalles(:_folio);", nativeQuery = true)
    TicketDetallesInfo obtenerDetalles(@Param("_folio") String folio);

    @Query("SELECT ticket.id AS id, " + "ticket.folio AS folio, " + "estadoReporte.nombre AS estadoNombre, " + "area.nombre AS reporteAreaNombre, " + "reporte.nombre AS reporteNombre, " + "unidad.clave AS unidadClave, " + "unidad.nombre AS unidadNombre, " + "ticket.fecha AS fecha " + "FROM Ticket ticket " + "INNER JOIN ticket.estado estadoReporte " + "INNER JOIN ticket.unidad unidad " + "INNER JOIN ticket.reporte reporte " + "INNER JOIN reporte.area area " + "WHERE (:idEstado IS NULL OR ticket.estado.id = :idEstado) " + "AND (:idUnidad IS NULL OR ticket.unidad.id = :idUnidad) " + "AND (:idArea IS NULL OR reporte.area.id = :idArea) " + "AND (:fecha IS NULL OR ticket.fecha >= :fecha) and ticket.visible = true")
    Page<TicketGeneralInfo> obtenerTickets(@Param("idEstado") Integer idEstado, @Param("idUnidad") Integer idUnidad, @Param("idArea") Integer idArea, @Param("fecha") LocalDateTime fecha, Pageable pageable);

    boolean existsByFolioAndVisible(String folio, Boolean visible);


    <T> Optional<T> findById(Integer integer, Class<T> type);
}