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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/olf")
@Tag(name = "Organisations Legal Forms", description = "Reference table with info about organisations legal forms")
public class OrgLegalFromController {
    private final OrgLegalFormInterface orgLegalFormInterface;

    @Autowired
    public OrgLegalFromController(OrgLegalFormInterface orgLegalFormInterface) {
        this.orgLegalFormInterface = orgLegalFormInterface;
    }

    @ResponseBody
    @PutMapping(path="/", produces = "application/json")
    @Operation(
        summary = "Create a Organisation legal form via entering all fields",
        description = "INPUT: Organisation legal form objects with all fields. RESPONSE: created object with code 200 or error with code 500",
        tags = {"organisations legal forms", "put"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = OrgLegalForm.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> createOrgLegalForm(@RequestBody OrgLegalForm orgLegalForm) {
        try {
           return new ResponseEntity<OrgLegalForm>(orgLegalFormInterface.createEntity(orgLegalForm), HttpStatus.OK); 
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path="/", produces = "application/json")
    @Operation(
        summary = "Returns all Organisation legal form",
        description = "RESPONSE: Organisation legal forms with code 200 or error with code 500",
        tags = {"organisations legal forms", "get"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = OrgLegalForm.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> getOrgLegalForms() {
        try {
            return new ResponseEntity<List<OrgLegalForm>>(orgLegalFormInterface.getAll(), HttpStatus.OK); 
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path="/{OrgLegalFormId}", produces = "application/json")
    @Operation(
        summary = "Returns Organisation legal form via ID",
        description = "RESPONSE: Organisation legal forms with code 200 or error with code 500",
        tags = {"organisations legal forms", "get"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = OrgLegalForm.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> getOrgLegalForm(@PathVariable int OrgLegalFormId) {
        try {
            return new ResponseEntity<OrgLegalForm>(orgLegalFormInterface.getEntity(OrgLegalFormId), HttpStatus.OK); 
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @PatchMapping(path="/{OrgLegalFormId}", produces = "application/json")
    @Operation(
        summary = "Updates Organisation legal form via ID",
        description = "INPUT: New olf or fields with new values. RESPONSE: Updated or created (if olf with that id not found) Organisation legal form with code 200 or error with code 500",
        tags = {"organisations legal forms", "patch"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = OrgLegalForm.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> updateOrgLegalForm(@PathVariable int OrgLegalFormId, @RequestBody OrgLegalForm orgLegalForm) throws IllegalAccessException, InvocationTargetException {
        try {
            return new ResponseEntity<OrgLegalForm>(orgLegalFormInterface.updateEntity(OrgLegalFormId, orgLegalForm), HttpStatus.OK); 
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @DeleteMapping(path="/{OrgLegalFormId}", produces = "application/json")
    @Operation(
        summary = "Deletes Organisation legal form via ID",
        description = "RESPONSE: Code 200 or error with code 500",
        tags = {"organisations legal forms", "delete"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema())}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> deleteOrgLegalForm(@PathVariable int OrgLegalFormId) {
        try {
            orgLegalFormInterface.deleteEntity(OrgLegalFormId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
        
    } 
}
