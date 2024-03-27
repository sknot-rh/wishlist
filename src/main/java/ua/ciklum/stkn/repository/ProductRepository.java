package ua.ciklum.stkn.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ua.ciklum.stkn.entity.Product;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {
}