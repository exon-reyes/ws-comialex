package nova.it.common.exception;

public class UnidadException extends RuntimeException {
    private final Integer code;

    public UnidadException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
