package bancocuscatlan.api.gateway.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bancocuscatlan.api.gateway.Common.RequestDTO;
import bancocuscatlan.api.gateway.Domain.GatewayDomain;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/gateway")
public class GatewayController {

    @Autowired
    private GatewayDomain gatewayDomain;

    @PostMapping("/post")
    public ResponseEntity getRequest(@RequestBody RequestDTO requestDTO) {
        return gatewayDomain.getRequest(requestDTO);
    }
}
