package com.example.BazaClients.repositories;

import com.example.BazaClients.models.User;
import com.example.BazaClients.models.bazaclients.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByName (String username);

    @Query("select distinct u from User u join fetch u.roles")
    List<User> findAll();

    @Query("select distinct c from Client c join fetch c.address")
    List<Client> findClientAll();
}
