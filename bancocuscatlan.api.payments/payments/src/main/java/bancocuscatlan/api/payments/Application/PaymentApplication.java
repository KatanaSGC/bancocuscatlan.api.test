package bancocuscatlan.api.payments.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bancocuscatlan.api.payments.Common.DTO.Payment.PaymentDTO;
import bancocuscatlan.api.payments.Common.Response.DomainResponse;
import bancocuscatlan.api.payments.Common.Response.ResponseDTO;
import bancocuscatlan.api.payments.Domain.PaymentDomain;

@Service
public class PaymentApplication {

    @Autowired
    private PaymentDomain _paymentDomain;

    public ResponseDTO<Boolean> ProcessPayment(PaymentDTO paymentDTO) {
        var response = new ResponseDTO<Boolean>();

        try {
            var processPayment = _paymentDomain.ProcessPayment(paymentDTO);

            response.setResponse(true);
            response.setMessage("Payment processed successfully.");
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
