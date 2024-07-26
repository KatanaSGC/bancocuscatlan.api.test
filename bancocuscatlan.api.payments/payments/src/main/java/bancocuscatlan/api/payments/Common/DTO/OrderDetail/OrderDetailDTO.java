package bancocuscatlan.api.payments.Common.DTO.OrderDetail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDTO {
    private int productId;
    private float price;
    private int count;
    private boolean status;
}
