package com.example.BazaClients.services;

import com.example.BazaClients.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.BazaClients.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;

@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan("com.example.demo")
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User findByName (String username){
        return userRepository.findByName(username);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findByName(s);
        System.out.println(user);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User " + s + " not found"));
        }
        return user;
    }
}
