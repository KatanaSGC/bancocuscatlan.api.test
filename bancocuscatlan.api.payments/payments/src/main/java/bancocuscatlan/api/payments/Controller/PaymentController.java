package bancocuscatlan.api.payments.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bancocuscatlan.api.payments.Application.PaymentApplication;
import bancocuscatlan.api.payments.Common.DTO.Payment.PaymentDTO;
import bancocuscatlan.api.payments.Common.Response.ResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentApplication _paymentApplication;

    @PostMapping("process-payment")
    public ResponseDTO<Boolean> ProcessPayment(@RequestBody PaymentDTO paymentDTO) {
        return _paymentApplication.ProcessPayment(paymentDTO);
    }
}
