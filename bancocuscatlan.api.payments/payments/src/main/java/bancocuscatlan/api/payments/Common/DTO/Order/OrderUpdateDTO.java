package bancocuscatlan.api.payments.Common.DTO.Order;

import bancocuscatlan.api.payments.Common.DTO.OrderDetail.OrderDetailDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderUpdateDTO {
    private String clientIdentification;
    private OrderDetailDTO orderDetail;
}
