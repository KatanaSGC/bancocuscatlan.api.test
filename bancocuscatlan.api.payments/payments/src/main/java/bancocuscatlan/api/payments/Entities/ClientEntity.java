package bancocuscatlan.api.payments.Entities;

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

@Entity
@Getter
@Setter
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "second_name", nullable = true, length = 50)
    private String secondName;
    @Column(name = "first_surname", nullable = false, length = 50)
    private String firstSurname;
    @Column(name = "second_surname", nullable = true, length = 50)
    private String secondSurname;
    @Column(name = "dni", nullable = false, length = 25)
    private String dni;
    @Column(name = "cell_phone", nullable = true, length = 20)
    private String cellphone;
    @Column(name = "email", nullable = true, length = 60)
    private String email;

    @Column(name = "status")
    private boolean status;
    
    @OneToMany(mappedBy = "client")
    private List<OrderClientEntity> orderClients;
}
