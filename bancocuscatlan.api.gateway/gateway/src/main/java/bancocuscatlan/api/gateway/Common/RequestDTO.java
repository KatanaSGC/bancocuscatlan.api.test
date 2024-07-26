package bancocuscatlan.api.gateway.Common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {
    private String microservice;
    private String endPoint;
    private String body;
}
