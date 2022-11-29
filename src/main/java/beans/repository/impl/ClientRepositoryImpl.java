package beans.repository.impl;

import beans.repository.ClientRepository;
import entities.Client;

import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class ClientRepositoryImpl extends AbstractRepository implements ClientRepository {
    @Override
    public Client getClient(Integer id) {
        return entityManager.find(Client.class, id);
    }

    @Override
    public List<Client> findClientByLoginAndPassword(String login, String password) {
        return entityManager.createQuery(
                "select client from Client client where client.isDeleted = false and client.login = :login and client.password = :password ",
                Client.class).setParameter("login", login).setParameter("password", password).getResultList();
    }
}
