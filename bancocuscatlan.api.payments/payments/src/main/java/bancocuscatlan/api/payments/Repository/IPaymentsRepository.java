package bancocuscatlan.api.payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bancocuscatlan.api.payments.Entities.PaymentEntity;

@Repository
public interface IPaymentsRepository extends JpaRepository<PaymentEntity, Integer> {

}
