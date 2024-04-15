package ua.ciklum.stkn.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Client extends AuditableEntity {
    private String firstName;

    private String lastName;

    private Boolean active;

    @Formula("upper(concat(firstName, '_', lastName))")
    private String userName;

    @JsonManagedReference
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Wishlist> wishes = new ArrayList<>();

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = true;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addWishlist(Wishlist wishes) {
        wishes.setClient(this);
        this.wishes.add(wishes);
    }

    public Client() {
    }

    public Boolean getActive() {
        return active;
    }

    public List<Wishlist> getWishes() {
        return wishes;
    }

    public String getUserName() {
        return userName;
    }
}

