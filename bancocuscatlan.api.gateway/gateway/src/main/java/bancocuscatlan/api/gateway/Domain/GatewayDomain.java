package bancocuscatlan.api.gateway.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import bancocuscatlan.api.gateway.Common.RequestDTO;

@Service
public class GatewayDomain {

    @Autowired
    private Environment env;

    public ResponseEntity getRequest(RequestDTO requestDTO) {

        try {

            var restClient = RestClient.create();

            var urlBase = env.getProperty(requestDTO.getMicroservice());

            var uri = urlBase + requestDTO.getEndPoint();

            return restClient.get()
                    .uri(uri)
                    .retrieve()
                    .toEntity(Object.class);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity postRequest(RequestDTO requestDTO) {

        try {
            var restClient = RestClient.create();

            var urlBase = env.getProperty(requestDTO.getMicroservice());

            var uri = urlBase + requestDTO.getEndPoint();

            //return restTemplate.postForEntity(uri, requestDTO.getBody(), Object.class);

            return restClient.post()
                    .uri(uri)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(requestDTO.getBody())
                    .retrieve()
                    .body(ResponseEntity.class);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity putRequest(RequestDTO requestDTO) {

        try {

            var restClient = RestClient.create();

            var urlBase = env.getProperty(requestDTO.getMicroservice());

            var uri = urlBase + requestDTO.getEndPoint();

            return restClient.put()
                    .uri(uri)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(requestDTO.getBody())
                    .retrieve()
                    .body(ResponseEntity.class);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
