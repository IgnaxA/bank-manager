package com.ip.bankmanager.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ip.bankmanager.entities.Client;
import com.ip.bankmanager.interfaces.ClientInterface;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    private final ClientInterface clientInterface;

    @Autowired
    public ClientController(ClientInterface clientInterface) {
        this.clientInterface = clientInterface;
    }

    @ResponseBody
    @PutMapping(path = "/", produces = "application/json")
    public Client createClient(@RequestBody Client client) {
        return clientInterface.createEntity(client);
    }

    @ResponseBody
    @GetMapping(path = "/", produces = "application/json") 
    public List<Client> getClients() {
        return clientInterface.getAll();
    }

    @ResponseBody
    @GetMapping(path = "/{clientId}", produces = "application/json")
    public Client getClient(@PathVariable int clientId) {
        return clientInterface.getEntity(clientId);
    }

    @ResponseBody
    @PatchMapping(path = "/{clientId}", produces = "application/json")
    public Client updateClient(@PathVariable int clientId, @RequestBody Client client) throws IllegalAccessException, InvocationTargetException {
        return clientInterface.updateEntity(clientId, client);
    }


    @ResponseBody
    @DeleteMapping(path="/{bankId}", produces = "application/json")
    public void deleteBank(@PathVariable int bankId) {
        clientInterface.deleteEntity(bankId);
    }
}
