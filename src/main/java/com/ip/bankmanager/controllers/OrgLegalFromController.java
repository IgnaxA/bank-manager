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

import com.ip.bankmanager.entities.OrgLegalForm;
import com.ip.bankmanager.interfaces.OrgLegalFormInterface;

@RestController
@RequestMapping(value = "/olf")
public class OrgLegalFromController {
    private final OrgLegalFormInterface orgLegalFormInterface;

    @Autowired
    public OrgLegalFromController(OrgLegalFormInterface orgLegalFormInterface) {
        this.orgLegalFormInterface = orgLegalFormInterface;
    }

    @ResponseBody
    @PutMapping(path="/", produces = "application/json")
    public OrgLegalForm createDeposit(@RequestBody OrgLegalForm orgLegalForm) {
        return orgLegalFormInterface.createEntity(orgLegalForm);
    }

    @ResponseBody
    @GetMapping(path="/", produces = "application/json")
    public List<OrgLegalForm> getDeposits() {
        return orgLegalFormInterface.getAll();
    }

    @ResponseBody
    @GetMapping(path="/{OrgLegalFormId}", produces = "application/json")
    public OrgLegalForm getDeposit(@PathVariable int OrgLegalFormId) {
        return orgLegalFormInterface.getEntity(OrgLegalFormId);
    }

    @ResponseBody
    @PatchMapping(path="/{OrgLegalFormId}", produces = "application/json")
    public OrgLegalForm updateBank(@PathVariable int OrgLegalFormId, @RequestBody OrgLegalForm orgLegalForm) throws IllegalAccessException, InvocationTargetException {
        return orgLegalFormInterface.updateEntity(OrgLegalFormId, orgLegalForm);
    }

    @ResponseBody
    @DeleteMapping(path="/{OrgLegalFormId}", produces = "application/json")
    public void deleteBank(@PathVariable int OrgLegalFormId) {
        orgLegalFormInterface.deleteEntity(OrgLegalFormId);
    }
}
