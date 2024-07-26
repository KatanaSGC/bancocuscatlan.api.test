package bancocuscatlan.api.payments.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bancocuscatlan.api.payments.Application.OrderApplication;
import bancocuscatlan.api.payments.Common.DTO.Order.OrderUpdateDTO;
import bancocuscatlan.api.payments.Common.Response.ResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderApplication _orderApplication;

    @GetMapping("create-order")
    public ResponseDTO<String> CreateOrder() {
        return _orderApplication.CreateOrder();
    }
    
    @PutMapping("update-order")
    public ResponseDTO<Boolean> UpdateOrder(@RequestBody OrderUpdateDTO orderUpdate) {
        return _orderApplication.UpdateOrder(orderUpdate);
    }
}
