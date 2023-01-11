package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "date_purchased")
    private Timestamp datePurchased;

    @Column(name = "total")
    private float total;

    public Sales(int customerId, Timestamp datePurchased, float total) {
        this.customer.setId(customerId);
        this.datePurchased = datePurchased;
        this.total = total;
    }
}



