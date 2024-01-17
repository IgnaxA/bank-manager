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

@RestController
@RequestMapping(value = "/banks")
public class BankController {
    private final BankInterface bankInterface;

    @Autowired
    public BankController(BankInterface bankInterface) {
        this.bankInterface = bankInterface;
    }

    @ResponseBody
    @PutMapping(path="/", produces = "application/json")
    public ResponseEntity<?> createBank(@RequestBody Bank bank) {
        try {
            return new ResponseEntity<Bank>(bankInterface.createEntity(bank), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<?> getBanks() {
        try {
            return new ResponseEntity<List<Bank>>(bankInterface.getAll(), HttpStatus.OK);
        } catch(Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path="/{bankId}", produces = "application/json")
    public ResponseEntity<?> getBank(@PathVariable int bankId) {
        try {
            return new ResponseEntity<Bank>(bankInterface.getEntity(bankId), HttpStatus.OK);
        } catch(Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @PatchMapping(path="/{bankId}", produces = "application/json")
    public ResponseEntity<?> updateBank(@PathVariable int bankId, @RequestBody Bank bank) throws IllegalAccessException, InvocationTargetException {
        try {
            return new ResponseEntity<Bank>(bankInterface.updateEntity(bankId, bank), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @DeleteMapping(path="/{bankId}", produces = "application/json")
    public ResponseEntity<?> deleteBank(@PathVariable int bankId) {
        try {
            bankInterface.deleteEntity(bankId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }
}
