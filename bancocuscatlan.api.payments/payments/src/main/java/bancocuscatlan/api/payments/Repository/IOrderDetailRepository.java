package bancocuscatlan.api.payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import bancocuscatlan.api.payments.Entities.OrderDetailEntity;
import bancocuscatlan.api.payments.Entities.OrderEntity;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetailEntity, Integer> {
    List<OrderDetailEntity> findAllByOrderidAndProductId(OrderEntity orderEntity, int productId);
    List<OrderDetailEntity> findAllByOrderid(OrderEntity orderEntity);
}
