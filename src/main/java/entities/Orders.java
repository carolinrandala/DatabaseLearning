package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "sales_id")
    private Sales saleId;

    @ManyToOne
    @JoinColumn(name = "item_id")
        private Items itemId;

    @Column(name = "qty_purchased")
        private int qtyPurchased;

    @Column(name = "item_total")
        private int total;


}
