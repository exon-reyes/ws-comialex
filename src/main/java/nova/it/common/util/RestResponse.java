package nova.it.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponse {
    private Object data;
    private Map<String, String> errors;
    private String message;
    private Integer status;
}
