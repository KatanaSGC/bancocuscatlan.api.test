package bancocuscatlan.api.payments.Entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.time.*;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "client_identification", nullable = false)
    private String clientIdentification;
    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "total_amount")
    private float totalAmount;
    @Column(name = "status")
    private boolean status;

    @OneToMany(mappedBy = "orderid")
    private List<OrderClientEntity> orderClients;

    @OneToMany(mappedBy = "orderid")
    private List<OrderDetailEntity> orderDetails;
}
