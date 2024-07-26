package bancocuscatlan.api.payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import bancocuscatlan.api.payments.Entities.OrderEntity;

@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity, Integer> {
    Optional<OrderEntity> findByClientIdentification(String clientIdentification);
    Optional<OrderEntity> findByClientIdentificationAndIsActive(String clientIdentification, boolean status);
}
