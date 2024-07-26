package bancocuscatlan.api.payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bancocuscatlan.api.payments.Entities.OrderClientEntity;

@Repository
public interface IOrderClientRepository extends JpaRepository<OrderClientEntity, Integer> {

}
