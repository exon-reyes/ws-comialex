package nova.it.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TicketParams {
    private LocalDateTime fecha;
    private Integer pagina, filas, idUnidad, idEstado, idArea;
}
