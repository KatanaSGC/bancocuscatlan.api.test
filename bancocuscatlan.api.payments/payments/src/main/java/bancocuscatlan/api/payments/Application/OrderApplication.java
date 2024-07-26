package bancocuscatlan.api.payments.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bancocuscatlan.api.payments.Common.DTO.Order.OrderUpdateDTO;
import bancocuscatlan.api.payments.Common.Response.DomainResponse;
import bancocuscatlan.api.payments.Common.Response.ResponseDTO;
import bancocuscatlan.api.payments.Domain.OrderDomain;

@Service
public class OrderApplication {
    
    @Autowired
    private OrderDomain _orderDomain;

    public ResponseDTO<String> CreateOrder() {

        var response = new ResponseDTO<String>();
        
        try {
            var create = _orderDomain.CreateOrder();

            response.setResponse(create.getValue1());
            response.setMessage("Order created successfully.");
            response.setStatusCode(200);
            return response;
        } catch (Exception e) {
            response.setMessage("Error");
            response.setError(e.getMessage());
            response.setStatusCode(500);
            return response;
        }
    }

    public ResponseDTO<Boolean> UpdateOrder(OrderUpdateDTO orderUpdate) {

        var response = new ResponseDTO<Boolean>();
        
        try {
            var update = _orderDomain.UpdateOrder(orderUpdate);
            if (update == DomainResponse.Increment) {
                response.setResponse(true);
                response.setMessage("Product was added to the order.");
                response.setStatusCode(200);
                return response;
            }

            response.setResponse(true);
            response.setMessage("Product was subtracted from the order.");
            response.setStatusCode(200);
            return response;
            
        } catch (Exception e) {
            response.setMessage("Error");
            response.setError(e.getMessage());
            response.setStatusCode(500);
            return response;
        }
    }
}
