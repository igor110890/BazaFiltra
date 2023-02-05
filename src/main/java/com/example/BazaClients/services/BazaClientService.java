package com.example.BazaClients.services;

import com.example.BazaClients.models.bazaclients.Client;

import java.util.List;

public interface BazaClientService {

    List<Client> findAll();

    Client findById(Long id);

    void save(Client client);

    void delete(Long id);

    void update(Client client);
}
