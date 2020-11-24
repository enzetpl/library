package pl.pussy.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pussy.library.exceptions.ResourceNotFoundException;
import pl.pussy.library.model.Client;
import pl.pussy.library.repository.ClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client with id: " + id + " not found"));
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }
}
