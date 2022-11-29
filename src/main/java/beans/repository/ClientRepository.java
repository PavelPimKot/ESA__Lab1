package beans.repository;

import entities.Client;

import java.util.List;

public interface ClientRepository extends Repository {
    Client getClient(Integer id);

    List<Client> findClientByLoginAndPassword(String login, String password);
}
