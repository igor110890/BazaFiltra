package com.example.BazaClients.services;

import com.example.BazaClients.models.Role;
import com.example.BazaClients.models.User;
import com.example.BazaClients.models.bazaclients.Client;

import java.util.List;
import java.util.Set;

public interface UserService {
    public List<User> findAll();

    public List<Client> findClientAll();

    public User findById(Long id);

    public void save(User user);

    public void delete(Long id);

    public List<Role> roles();

    public Role roleForId(Long id);

    public Role findByRole(String role);

    public Set<Role> findByRoleSet(String role);

    public void update(User user);
}
