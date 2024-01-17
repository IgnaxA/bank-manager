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

import com.ip.bankmanager.entities.Bank;
import com.ip.bankmanager.interfaces.BankInterface;
import com.ip.bankmanager.validators.ResponseHandler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/banks")
@Tag(name = "Bank", description = "Banks that can give deposits to clients")
public class BankController {
    private final BankInterface bankInterface;

    @Autowired
    public BankController(BankInterface bankInterface) {
        this.bankInterface = bankInterface;
    }

    @ResponseBody
    @PutMapping(path="/", produces = "application/json")
    @Operation(
        summary = "Create a bank via entering all fields",
        description = "INPUT: Bank objects with all fields. RESPONSE: created object with code 200 or error with code 500",
        tags = {"banks", "put"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Bank.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> createBank(@RequestBody Bank bank) {
        try {
            return new ResponseEntity<Bank>(bankInterface.createEntity(bank), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path="/", produces = "application/json")
    @Operation(
        summary = "Returns all banks",
        description = "RESPONSE: Banks with code 200 or error with code 500",
        tags = {"banks", "get"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Bank.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> getBanks() {
        try {
            return new ResponseEntity<List<Bank>>(bankInterface.getAll(), HttpStatus.OK);
        } catch(Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path="/{bankId}", produces = "application/json")
    @Operation(
        summary = "Returns bank via ID",
        description = "RESPONSE: Bank with code 200 or error with code 500",
        tags = {"banks", "get"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Bank.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> getBank(@PathVariable int bankId) {
        try {
            return new ResponseEntity<Bank>(bankInterface.getEntity(bankId), HttpStatus.OK);
        } catch(Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @PatchMapping(path="/{bankId}", produces = "application/json")
    @Operation(
        summary = "Updates bank via ID",
        description = "INPUT: New bank or fields with new values. RESPONSE: Updated or created (if bank with that id not found) bank with code 200 or error with code 500",
        tags = {"banks", "patch"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Bank.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> updateBank(@PathVariable int bankId, @RequestBody Bank bank) throws IllegalAccessException, InvocationTargetException {
        try {
            return new ResponseEntity<Bank>(bankInterface.updateEntity(bankId, bank), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @DeleteMapping(path="/{bankId}", produces = "application/json")
    @Operation(
        summary = "Deletes bank via ID",
        description = "RESPONSE: Code 200 or error with code 500",
        tags = {"banks", "delete"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema())}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> deleteBank(@PathVariable int bankId) {
        try {
            bankInterface.deleteEntity(bankId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }
}
