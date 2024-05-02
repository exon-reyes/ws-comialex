package nova.it.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeguimientoDTO {
    Integer id;
    Integer ticketId;
    Integer estadoId;
    String agente;
    LocalDateTime fecha;
    String nota;
}
