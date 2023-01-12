package entities;

import db.Database;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;


@Entity(name = "customer")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;

    static Session session = Database.getHibSesh();


    public Customer(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public static void createCustomer(Customer customer) {
        // - Differences between certain Hibernate methods

        session.beginTransaction();
        Transaction trans = session.getTransaction();

        try {
            session.persist(customer);
            session.flush();
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }
    }

    // - How to hack the select * from []; query
    public static void listCustomers() {
        Session session = Database.getHibSesh();
       // Transaction transaction = session.beginTransaction();

        try {
            session.beginTransaction();
            List<Customer> customers = session.createQuery(" from customer").list();

            for (Customer customer : customers) {
                System.out.println(customer);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateCustomer(String firstName, int customerId) {
        // - Differences between certain Hibernate methods

        session.beginTransaction();
        Transaction trans = session.getTransaction();
        Customer customer = session.get(Customer.class, customerId);
        customer.setFirstname(firstName);


        try {
            session.merge(customer);  // merge doesn't change values to 0 like update
            session.flush();
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        }
    }
    public static void deleteCustomer(int customerId) {
        // - Differences between certain Hibernate methods

        // Note: It's always recommended to use transactions when
        // deleting something, so in the event that you are carrying out other
        // operations which you want to occur simultaneously with the deletion
        // if there's error the entire operation is rolled back and nothing is deleted
        session.beginTransaction();
        Transaction trans = session.getTransaction();
        Customer customer = session.get(Customer.class, customerId);

        try {
            session.delete(customer);  // merge doesn't change values to 0 like update
            session.flush(); // cleans the connection with database
            trans.commit(); // if it's succesful we commit
        } catch (Exception e) {
            trans.rollback(); // if not we rollback the process to save data use
            e.printStackTrace();
        }
    }
}
