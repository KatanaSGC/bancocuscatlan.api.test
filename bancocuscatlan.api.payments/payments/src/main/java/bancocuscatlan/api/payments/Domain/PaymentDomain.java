package bancocuscatlan.api.payments.Domain;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bancocuscatlan.api.payments.Common.DTO.Payment.PaymentDTO;
import bancocuscatlan.api.payments.Common.Response.DomainResponse;
import bancocuscatlan.api.payments.Entities.PaymentEntity;
import bancocuscatlan.api.payments.Repository.IOrderRepository;
import bancocuscatlan.api.payments.Repository.IPaymentsRepository;

@Service
public class PaymentDomain {
    @Autowired
    private IPaymentsRepository _paymentsRepository;

    @Autowired 
    private IOrderRepository _orderRepository;

    public DomainResponse ProcessPayment(PaymentDTO paymentDTO) throws Exception
    {
        var findOrder = _orderRepository.findByClientIdentificationAndIsActive(paymentDTO.getClientIdentification(), true);
        if(!findOrder.isPresent()) throw new Exception("Order not found or is inactive.");

        var findOrderDetail = findOrder.get().getOrderDetails();

        if(findOrderDetail.isEmpty()) throw new Exception("Order detail not found.");

        var findProducts = findOrderDetail.stream().map(orderDetail -> orderDetail.getProductId()).distinct().toList();        

        var totalAmountProducts = new ArrayList<Float>();

        findProducts.forEach(product -> { 

            var countProduct = findOrderDetail.stream().filter(orderDetail -> orderDetail.getProductId() == product).mapToInt(x -> x.getCount()).sum();
            var individualPrice = findOrderDetail.stream().findFirst();

            totalAmountProducts.add(individualPrice.get().getPrice() * countProduct);
        });

        var totalAmount = (float) totalAmountProducts.stream().mapToDouble(x -> x).sum();

        var payment = new PaymentEntity();
        payment.setAmount(totalAmount);
        payment.setCreationDate(java.time.LocalDate.now());
        payment.setStatus(true);
        payment.setOrder(findOrder.get());
        _paymentsRepository.save(payment);

        findOrder.get().setActive(false);
        _orderRepository.save(findOrder.get());
    
        return DomainResponse.Success;
    }
}
