package bancocuscatlan.api.payments.Common.DTO.Payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
    private String clientIdentification;
    private String creditCardNumber;
    private String creditCardSecurityCode;
    private String creditCardExpirationDate;
    private String creditCardName;
}
