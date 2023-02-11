package com.example.BazaClients.controllers;

import com.example.BazaClients.models.Role;
import com.example.BazaClients.models.User;
import com.example.BazaClients.models.bazaclients.Address;
import com.example.BazaClients.models.bazaclients.Client;
import com.example.BazaClients.services.UserService;
import com.example.BazaClients.services.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class MyRestAdminController {

    private final UserService userServiceImpl;

    public MyRestAdminController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/getAuthorizedUser")
    public ResponseEntity<?> getAuthorizedUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok().body(userServiceImpl.findAll());
    }

    @GetMapping("/allClient")
    public ResponseEntity<List<Client>> getAllClient() {
        return ResponseEntity.ok().body(userServiceImpl.findClientAll());
    }

    @GetMapping("getUser/{id}")
    public ResponseEntity<User> show(@PathVariable Long id) {
        User user = userServiceImpl.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/create/{new_Roles}")
    public ResponseEntity<User> create(@RequestBody User user, @PathVariable(required = false, name = "new_Roles") String roleString) {
        Set<Role> setRoleController;
        setRoleController = userServiceImpl.findByRoleSet(roleString);
        user.setRoles(setRoleController);
        userServiceImpl.save(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/update/{new_Roles}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable(required = false, name = "new_Roles") String roleString) {
        Set<Role> setRoleController;
        setRoleController = userServiceImpl.findByRoleSet(roleString);
        user.setRoles(setRoleController);
        userServiceImpl.update(user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
