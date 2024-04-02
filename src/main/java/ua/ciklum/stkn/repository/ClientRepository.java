package ua.ciklum.stkn.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import ua.ciklum.stkn.entity.Client;


@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> {


    public Client getByUserName(String userName) {
        return this.find("userName", userName).firstResult();
    };

    //@EntityGraph(attributePaths = {"wishes"})
    public Client findByUserName(String userName) {
        return this.find("userName", userName).firstResult();
    }

    //@EntityGraph(attributePaths = {"wishes.products"})
    public Client findClientByUserName(String userName) {
        return this.find("userName", userName).firstResult();
    }
}