package nova.it.common.exception;

public class TicketException extends RuntimeException {
    private final Integer code;

    public TicketException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
