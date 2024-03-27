package ua.ciklum.stkn.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import ua.ciklum.stkn.entity.Client;
import ua.ciklum.stkn.repository.ClientRepository;

@ApplicationScoped
@Path("/clients")
public class ClientController {

    @Inject
    ClientRepository repository;

    @Path("/search/findByUserName")
    @GET
    public Client getByName(@QueryParam("userName") String userName) {
        Client client = repository.findClientByUserName(userName);
        return client;
    }
}