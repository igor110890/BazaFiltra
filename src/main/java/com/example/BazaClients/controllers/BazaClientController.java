package com.example.BazaClients.controllers;

import com.example.BazaClients.models.bazaclients.Client;
import com.example.BazaClients.services.BazaClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BazaClientController {

    private final BazaClientService bazaClientServiceImpl;

    public BazaClientController(BazaClientService bazaClientServiceImpl) {
        this.bazaClientServiceImpl = bazaClientServiceImpl;
    }

    @GetMapping("/allClient")
    public ResponseEntity<List<Client>> getAllUser() {
        return ResponseEntity.ok().body(bazaClientServiceImpl.findAll());
    }

    @GetMapping("getClient/{id}")
    public ResponseEntity<Client> show(@PathVariable Long id) {
        Client client = bazaClientServiceImpl.findById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/createClient/{new_Client}")
    public ResponseEntity<Client> create(@RequestBody Client client, @PathVariable(required = false, name = "new_Client") String roleString) {
        bazaClientServiceImpl.save(client);
        return ResponseEntity.ok().body(client);
    }

    @PutMapping("/updateClient/{new_Roles}")
    public ResponseEntity<?> update(@RequestBody Client client, @PathVariable(required = false, name = "new_Client") String roleString) {
        bazaClientServiceImpl.update(client);
        return ResponseEntity.ok().body(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        bazaClientServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
