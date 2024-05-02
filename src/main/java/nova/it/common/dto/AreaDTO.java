package nova.it.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link nova.it.model.entity.Area}
 */
@AllArgsConstructor
@Getter
public class AreaDTO implements Serializable {
    private final Integer id;
    private final String nombre;
}