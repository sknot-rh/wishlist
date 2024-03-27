package ua.ciklum.stkn.repository;


import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import ua.ciklum.stkn.entity.Client;
import ua.ciklum.stkn.entity.Product;
import ua.ciklum.stkn.entity.Wishlist;

import java.util.List;

@ApplicationScoped
public class DatabaseInitializer {

    private static final Logger LOGGER = Logger.getLogger(DatabaseInitializer.class);

    @Inject
    ClientRepository clientRepository;

    @Transactional
    public void run(@Observes StartupEvent startupEvent) {
        LOGGER.info("Initializing DB");
        Product tieFighter = new Product("TIE Fighter");
        Product deathStar = new Product("Death Star");
        Product starDestroyer = new Product("Star Destroyer");

        Wishlist wishlist = new Wishlist(List.of(tieFighter, deathStar, starDestroyer));

        Client vader = new Client("Darth", "Vader");
        vader.addWishlist(wishlist);

        clientRepository.persist(vader);
    }
}