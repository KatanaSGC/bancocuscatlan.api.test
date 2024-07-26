package bancocuscatlan.api.payments.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bancocuscatlan.api.payments.Entities.ClientEntity;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, Integer> {

}
