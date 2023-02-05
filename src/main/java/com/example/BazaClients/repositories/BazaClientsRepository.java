package com.example.BazaClients.repositories;

import com.example.BazaClients.models.bazaclients.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BazaClientsRepository extends JpaRepository<Client,Long> {

    @Query("select distinct c from Client c")
    List<Client> findAll();
}
