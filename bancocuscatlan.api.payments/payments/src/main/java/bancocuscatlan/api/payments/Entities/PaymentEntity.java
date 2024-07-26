package bancocuscatlan.api.payments.Entities;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.time.*;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class PaymentEntity {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float amount;
    private LocalDate creationDate;
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment")
    private OrderEntity order;
}
