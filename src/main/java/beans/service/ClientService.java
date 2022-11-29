package beans.service;

import entities.Client;

import java.util.List;

public interface ClientService {
    Client getClient(Integer id);

    List<Client> findClientByLoginAndPassword(String login, String password);

    void save(Client client);
}
