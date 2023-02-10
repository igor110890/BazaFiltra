package com.example.BazaClients.services;

import com.example.BazaClients.models.bazaclients.Address;
import com.example.BazaClients.models.bazaclients.Client;
import com.example.BazaClients.repositories.AddressRepository;
import com.example.BazaClients.repositories.BazaClientsRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
@Getter
@Setter
public class BazaClientServiceImpl implements BazaClientService {

    private final BazaClientsRepository bazaClientsRepository;
    private final AddressRepository addressRepository;

    public BazaClientServiceImpl(BazaClientsRepository bazaClientsRepository, AddressRepository addressRepository) {
        this.bazaClientsRepository = bazaClientsRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Client> findAll() {
        return bazaClientsRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return bazaClientsRepository.getById(id);
    }

    @Override
    public void save(Client client) {
        bazaClientsRepository.save(client);
    }

    @Override
    public void update(Client client) {
        bazaClientsRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        bazaClientsRepository.deleteById(id);
    }

    @Override
    public Address findByRole(String address) {
        return addressRepository.findByNameAddress(address);
    }
}
