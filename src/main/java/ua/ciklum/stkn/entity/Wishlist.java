package ua.ciklum.stkn.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Wishlist extends AuditableEntity {
    @JsonBackReference
    @ManyToOne
    Client client;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @OrderColumn
    List<Product> products;

    public Wishlist(List<Product> products) {
        this.products = products;
    }

    public Wishlist() {
    }
}