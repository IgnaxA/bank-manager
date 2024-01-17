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

import com.ip.bankmanager.entities.OrgLegalForm;
import com.ip.bankmanager.interfaces.OrgLegalFormInterface;
import com.ip.bankmanager.validators.ResponseHandler;

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
    public ResponseEntity<?> createDeposit(@RequestBody OrgLegalForm orgLegalForm) {
        try {
           return new ResponseEntity<OrgLegalForm>(orgLegalFormInterface.createEntity(orgLegalForm), HttpStatus.OK); 
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path="/", produces = "application/json")
    public ResponseEntity<?> getDeposits() {
        try {
            return new ResponseEntity<List<OrgLegalForm>>(orgLegalFormInterface.getAll(), HttpStatus.OK); 
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path="/{OrgLegalFormId}", produces = "application/json")
    public ResponseEntity<?> getDeposit(@PathVariable int OrgLegalFormId) {
        try {
            return new ResponseEntity<OrgLegalForm>(orgLegalFormInterface.getEntity(OrgLegalFormId), HttpStatus.OK); 
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @PatchMapping(path="/{OrgLegalFormId}", produces = "application/json")
    public ResponseEntity<?> updateBank(@PathVariable int OrgLegalFormId, @RequestBody OrgLegalForm orgLegalForm) throws IllegalAccessException, InvocationTargetException {
        try {
            return new ResponseEntity<OrgLegalForm>(orgLegalFormInterface.updateEntity(OrgLegalFormId, orgLegalForm), HttpStatus.OK); 
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @DeleteMapping(path="/{OrgLegalFormId}", produces = "application/json")
    public ResponseEntity<?> deleteBank(@PathVariable int OrgLegalFormId) {
        try {
            orgLegalFormInterface.deleteEntity(OrgLegalFormId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
        
    } 
}
