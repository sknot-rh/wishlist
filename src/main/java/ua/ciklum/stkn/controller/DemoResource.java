package ua.ciklum.stkn.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ua.ciklum.stkn.entity.Client;
import ua.ciklum.stkn.repository.ClientRepository;

import java.util.List;

@ApplicationScoped
@Path("")
public class DemoResource {

    @Inject
    ClientRepository clientRepository;

    @Path("/hello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String hello() {
        return "hello";
    }


    @Path("/store")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String store(Client client) {
        clientRepository.persist(client);
        //client.persist();
        return String.join(" ", "Client", client.getFirstName(), client.getLastName(), "persisted").toString();
    }

    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Client get(@QueryParam("id") long id) {
        // find
        Client client = clientRepository.findById(id);
        //Client client = Client.findById(id);
        if (client != null) {
            System.out.println("Test " + client.getFirstName());
        } else {
            System.err.println("User with id " + id + " not found!");
        }
        return client;
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getAll() {
        return clientRepository.listAll();
    }
}
