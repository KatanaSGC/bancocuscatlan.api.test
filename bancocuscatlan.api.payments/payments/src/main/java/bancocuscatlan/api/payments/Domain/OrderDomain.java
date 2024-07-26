package bancocuscatlan.api.payments.Domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import bancocuscatlan.api.payments.Common.DTO.Order.OrderUpdateDTO;
import bancocuscatlan.api.payments.Common.Response.DomainResponse;
import bancocuscatlan.api.payments.Entities.OrderDetailEntity;
import bancocuscatlan.api.payments.Entities.OrderEntity;
import bancocuscatlan.api.payments.Repository.IOrderDetailRepository;
import bancocuscatlan.api.payments.Repository.IOrderRepository;
import org.javatuples.Pair;

import java.time.LocalDate;

@Service
public class OrderDomain {

    @Autowired
    private IOrderDetailRepository _orderDetailRepository;

    @Autowired
    private IOrderRepository _orderRepository;

    public Pair<DomainResponse, String> CreateOrder() {
        var clientIdentification = UUID.randomUUID().toString();

        var order = new OrderEntity();
        order.setClientIdentification(clientIdentification);
        order.setActive(true);
        order.setCreationDate(LocalDate.now());
        order.setStatus(true);
        order.setTotalAmount(0);

        _orderRepository.save(order);

        return Pair.with(DomainResponse.Ok, clientIdentification);
    }

    public DomainResponse UpdateOrder(OrderUpdateDTO orderUpdate) throws Exception {
        var findOrder = _orderRepository.findByClientIdentification(orderUpdate.getClientIdentification());
        if (!findOrder.isPresent()) {
            throw new Exception("Order not found.");
        }

        var findOrderDetail = _orderDetailRepository.findAllByOrderidAndProductId(findOrder.get(),
                orderUpdate.getOrderDetail().getProductId());

        var orderDetail = new OrderDetailEntity();
        orderDetail.setOrderid(findOrder.get());
        orderDetail.setProductId(orderUpdate.getOrderDetail().getProductId());
        orderDetail.setPrice(orderUpdate.getOrderDetail().getPrice());
        orderDetail.setCount(orderUpdate.getOrderDetail().getCount());
        orderDetail.setStatus(true);

        if (findOrderDetail.isEmpty() && orderUpdate.getOrderDetail().getCount() > 0) {
            _orderDetailRepository.save(orderDetail);

            return DomainResponse.Increment;

        }

        var currentCount = findOrderDetail.stream().mapToInt(x -> x.getCount()).sum();
        var sumNewCount = currentCount + orderUpdate.getOrderDetail().getCount();

        if (sumNewCount >= 0) {
            _orderDetailRepository.save(orderDetail);

            return orderUpdate.getOrderDetail().getCount() > 0 ? DomainResponse.Increment : DomainResponse.Decrement;
        }

        throw new Exception("Cannot be a negative value.");
    }
}
