package com.ip.bankmanager.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.ip.bankmanager.validators.ResponseHandler;

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
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        try {
            return new ResponseEntity<Client>(clientInterface.createEntity(client), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path = "/", produces = "application/json") 
    public ResponseEntity<?> getClients() {
        try {
            return new ResponseEntity<List<Client>>(clientInterface.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path = "/{clientId}", produces = "application/json")
    public ResponseEntity<?> getClient(@PathVariable int clientId) {
        try {
            return new ResponseEntity<Client>(clientInterface.getEntity(clientId), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @PatchMapping(path = "/{clientId}", produces = "application/json")
    public ResponseEntity<?> updateClient(@PathVariable int clientId, @RequestBody Client client) throws IllegalAccessException, InvocationTargetException {
        try {
            return new ResponseEntity<Client>(clientInterface.updateEntity(clientId, client), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }


    @ResponseBody
    @DeleteMapping(path="/{bankId}", produces = "application/json")
    public ResponseEntity<?> deleteBank(@PathVariable int bankId) {
        try {
            clientInterface.deleteEntity(bankId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }
}
