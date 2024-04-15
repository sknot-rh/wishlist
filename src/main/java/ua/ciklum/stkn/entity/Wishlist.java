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

    public void setClient(Client client) {
        this.client = client;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public List<Product> getProducts() {
        return products;
    }
}