package ua.ciklum.stkn;

import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import ua.ciklum.stkn.repository.ClientRepository;

public class FetchTest {

    @Inject
    ClientRepository clientRepository;

    //check log to see the difference in SQL executed by Hibernate
    @Test
    public void testDefaultBehavior() {
        clientRepository.getByUserName("DARTH_VADER");
    }

    @Test
    public void testFetchOrders() {
        clientRepository.findByUserName("DARTH_VADER");
    }

    @Test
    public void testFetchOrdersAndProducts() {
        clientRepository.findClientByUserName("DARTH_VADER");
    }

}