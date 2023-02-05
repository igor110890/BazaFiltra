package com.example.BazaClients.services;

import com.example.BazaClients.models.Role;
import com.example.BazaClients.models.User;
import com.example.BazaClients.repositories.RoleRepository;
import com.example.BazaClients.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder BCryptPasswordEncoder;

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder BCryptPasswordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.BCryptPasswordEncoder = BCryptPasswordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void save(User user) {
        user.setPassword(BCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void update(User user) {
        user.setPassword(BCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Role> roles() {
        return roleRepository.findAll();
    }

    @Override
    public Role roleForId(Long id) {
        return roleRepository.getById(id);
    }

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByName(role);
    }

    @Override
    public Set<Role> findByRoleSet(String roles) {
        String[] role = roles.split(",");
        Set<Role> roles1 = new HashSet<>();
        for (String rollles : role) {
            if (rollles.equals("USER")) {
                roles1.add(findByRole("ROLE_USER"));
            } else if (rollles.equals("ADMIN")) {
                roles1.add(findByRole("ROLE_ADMIN"));
            } else {
                roles1.add(findByRole("ROLE_USER"));
            }
        }
        return roles1;
    }
}
