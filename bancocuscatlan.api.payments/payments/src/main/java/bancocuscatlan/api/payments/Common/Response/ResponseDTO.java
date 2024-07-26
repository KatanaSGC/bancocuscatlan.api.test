package bancocuscatlan.api.payments.Common.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {
    private T response;
    private String message;
    private int statusCode;
    private String error;
}
