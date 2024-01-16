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

import com.ip.bankmanager.entities.Deposit;
import com.ip.bankmanager.interfaces.DepositInterface;

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
    public Deposit createDeposit(@RequestBody Deposit deposit) {
        return depositInterface.createEntity(deposit);
    }

    @ResponseBody
    @GetMapping(path="/", produces = "application/json")
    public List<Deposit> getDeposits() {
        return depositInterface.getAll();
    }

    @ResponseBody
    @GetMapping(path="/{depositId}", produces = "application/json")
    public Deposit getDeposit(@PathVariable int depositId) {
        return depositInterface.getEntity(depositId);
    }

    @ResponseBody
    @PatchMapping(path="/{depositId}", produces = "application/json")
    public Deposit updateBank(@PathVariable int depositId, @RequestBody Deposit deposit) throws IllegalAccessException, InvocationTargetException {
        return depositInterface.updateEntity(depositId, deposit);
    }

    @ResponseBody
    @DeleteMapping(path="/{depositId}", produces = "application/json")
    public void deleteBank(@PathVariable int depositId) {
        depositInterface.deleteEntity(depositId);
    }
}
