package com.example.BazaClients.repositories;

import com.example.BazaClients.models.Role;
import com.example.BazaClients.models.bazaclients.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    public Address findByNameAddress(String address);
}
