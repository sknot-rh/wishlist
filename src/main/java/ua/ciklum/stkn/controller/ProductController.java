package ua.ciklum.stkn.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import ua.ciklum.stkn.entity.Product;
import ua.ciklum.stkn.repository.ProductRepository;

import java.util.List;

@ApplicationScoped
@Path("/product")
public class ProductController {
    @Inject
    ProductRepository repository;

    @POST
    @Path("/")
    public Product saveProduct(@Valid Product product) {
        repository.persist(product);
        return product;
    }

    @GET
    @Path("/")
    public List<Product> getAll() {
        return repository.listAll();
    }

    @GET
    @Path("/{id}")
    public Product getAll(@PathParam("id") long id) {
        return repository.findById(id);
    }
}