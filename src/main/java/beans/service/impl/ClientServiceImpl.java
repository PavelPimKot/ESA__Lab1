package beans.service.impl;

import beans.repository.ClientRepository;
import beans.service.ClientService;
import entities.Client;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

@Singleton
public class ClientServiceImpl implements ClientService {
    @EJB
    private ClientRepository clientRepository;

    @Override
    public Client getClient(Integer id) {
        return clientRepository.getClient(id);
    }

    @Override
    public List<Client> findClientByLoginAndPassword(String login, String password) {
        return clientRepository.findClientByLoginAndPassword(login, password);
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }
}
