package entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Items {
    // Using Hibernate create the entity object for the items class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "qty_in_stock")
    private int qty_in_stock;

    @Column(name = "price")
    private float price;

    public Items(String name, String description, int qty_in_stock, float price) {
        this.name = name;
        this.description = description;
        this.qty_in_stock = qty_in_stock;
        this.price = price;
    }
}
