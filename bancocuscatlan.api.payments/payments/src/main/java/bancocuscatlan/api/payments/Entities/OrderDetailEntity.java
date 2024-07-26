package bancocuscatlan.api.payments.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter
@Setter
@Table(name = "orders_details")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int productId;
    private int count;
    private float price;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "orderid")
    private OrderEntity orderid;
}
