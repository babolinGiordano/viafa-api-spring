package com.babo.bmbtrasporti.viafa.rest;

import com.babo.bmbtrasporti.viafa.entity.Client;
import com.babo.bmbtrasporti.viafa.exception.ApiNotFoundException;
import com.babo.bmbtrasporti.viafa.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/clients/{clientId}")
    public Client findById(@PathVariable int clientId) {
        Client client = clientService.findById(clientId);

        if (client == null) {
            throw new ApiNotFoundException("Client id not found - " + clientId);
        }

        return client;
    }

    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client) {
        client.setId(0);

        clientService.save(client);

        return client;
    }

    @PutMapping("/clients")
    public Client updateClient(@RequestBody Client client) {
        clientService.save(client);

        return client;
    }

    @DeleteMapping("/clients/{clientId}")
    public String deleteClient(@PathVariable int clientId) {
        Client client = clientService.findById(clientId);

        if (client == null) {
            throw new ApiNotFoundException("Client id not found - " + clientId);
        }

        clientService.deleteById(clientId);

        return "Deleted client id - " + clientId;
    }
}
