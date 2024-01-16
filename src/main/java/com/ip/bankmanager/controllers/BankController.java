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

import com.ip.bankmanager.entities.Bank;
import com.ip.bankmanager.interfaces.BankInterface;

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
    public Bank createBank(@RequestBody Bank bank) {
        return bankInterface.createEntity(bank);
    }

    @ResponseBody
    @GetMapping(path="/", produces = "application/json")
    public List<Bank> getBanks() {
        return bankInterface.getAll();
    }

    @ResponseBody
    @GetMapping(path="/{bankId}", produces = "application/json")
    public Bank getBank(@PathVariable int bankId) {
        return bankInterface.getEntity(bankId);
    }

    @ResponseBody
    @PatchMapping(path="/{bankId}", produces = "application/json")
    public Bank updateBank(@PathVariable int bankId, @RequestBody Bank bank) throws IllegalAccessException, InvocationTargetException {
        return bankInterface.updateEntity(bankId, bank);
    }

    @ResponseBody
    @DeleteMapping(path="/{bankId}", produces = "application/json")
    public void deleteBank(@PathVariable int bankId) {
        bankInterface.deleteEntity(bankId);
    }
}
