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

import com.ip.bankmanager.entities.Deposit;
import com.ip.bankmanager.interfaces.DepositInterface;
import com.ip.bankmanager.validators.ResponseHandler;

@RestController
@RequestMapping(value = "/deposits")
public class DepositController {
    private final DepositInterface depositInterface;

    @Autowired
    public DepositController(DepositInterface depositInterface) {
        this.depositInterface = depositInterface;
    }

    @ResponseBody
    @PutMapping(path="/", produces = "application/json")
    public ResponseEntity<?> createDeposit(@RequestBody Deposit deposit) {
        try {
            return new ResponseEntity<Deposit>(depositInterface.createEntity(deposit), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<?> getDeposits() {
        try {
            return new ResponseEntity<List<Deposit>>(depositInterface.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path="/{depositId}", produces = "application/json")
    public ResponseEntity<?> getDeposit(@PathVariable int depositId) {
        try {
            return new ResponseEntity<Deposit>(depositInterface.getEntity(depositId), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @PatchMapping(path="/{depositId}", produces = "application/json")
    public ResponseEntity<?> updateBank(@PathVariable int depositId, @RequestBody Deposit deposit) throws IllegalAccessException, InvocationTargetException {
        try {
            return new ResponseEntity<Deposit>(depositInterface.updateEntity(depositId, deposit), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @DeleteMapping(path="/{depositId}", produces = "application/json")
    public ResponseEntity<?> deleteBank(@PathVariable int depositId) {
        try {
            depositInterface.deleteEntity(depositId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
        
    }
}
