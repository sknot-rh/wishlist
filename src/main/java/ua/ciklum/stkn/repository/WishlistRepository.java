package ua.ciklum.stkn.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ua.ciklum.stkn.entity.Wishlist;

@ApplicationScoped
public class WishlistRepository implements PanacheRepository<Wishlist> {
}