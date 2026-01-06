package com.banking.service;

import com.banking.entity.Client;
import com.banking.exception.ResourceNotFoundException;
import com.banking.repository.ClientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found"));
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client clientDetails) {
        Client client = getClientById(id);
        client.setName(clientDetails.getName());
        client.setAccountNumber(clientDetails.getAccountNumber());
        client.setKycStatus(clientDetails.getKycStatus());
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
