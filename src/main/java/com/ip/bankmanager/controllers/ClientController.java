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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/clients")
@Tag(name = "Client", description = "Clients that can take deposits from banks")
public class ClientController {
    private final ClientInterface clientInterface;

    @Autowired
    public ClientController(ClientInterface clientInterface) {
        this.clientInterface = clientInterface;
    }

    @ResponseBody
    @PutMapping(path = "/", produces = "application/json")
    @Operation(
        summary = "Create a client via entering all fields",
        description = "INPUT: Client objects with all fields. RESPONSE: created object with code 200 or error with code 500",
        tags = {"clients", "put"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Client.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        try {
            return new ResponseEntity<Client>(clientInterface.createEntity(client), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path = "/", produces = "application/json")
    @Operation(
        summary = "Returns all clients",
        description = "RESPONSE: Clients with code 200 or error with code 500",
        tags = {"clients", "get"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Client.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> getClients() {
        try {
            return new ResponseEntity<List<Client>>(clientInterface.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path = "/{clientId}", produces = "application/json")
    @Operation(
        summary = "Returns client via ID",
        description = "RESPONSE: Client with code 200 or error with code 500",
        tags = {"clients", "get"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Client.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> getClient(@PathVariable int clientId) {
        try {
            return new ResponseEntity<Client>(clientInterface.getEntity(clientId), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @PatchMapping(path = "/{clientId}", produces = "application/json")
    @Operation(
        summary = "Updates client via ID",
        description = "INPUT: New client or fields with new values. RESPONSE: Updated or created (if client with that id not found) client with code 200 or error with code 500",
        tags = {"clients", "patch"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Client.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> updateClient(@PathVariable int clientId, @RequestBody Client client) throws IllegalAccessException, InvocationTargetException {
        try {
            return new ResponseEntity<Client>(clientInterface.updateEntity(clientId, client), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }


    @ResponseBody
    @DeleteMapping(path="/{clientId}", produces = "application/json")
    @Operation(
        summary = "Deletes client via ID",
        description = "RESPONSE: Code 200 or error with code 500",
        tags = {"clients", "delete"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema())}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> deleteClient(@PathVariable int clientId) {
        try {
            clientInterface.deleteEntity(clientId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }
}
