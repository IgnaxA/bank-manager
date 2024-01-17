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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/deposits")
@Tag(name = "Deposit", description = "Information about deposits")
public class DepositController {
    private final DepositInterface depositInterface;

    @Autowired
    public DepositController(DepositInterface depositInterface) {
        this.depositInterface = depositInterface;
    }

    @ResponseBody
    @PutMapping(path="/", produces = "application/json")
    @Operation(
        summary = "Create a deposit via entering all fields",
        description = "INPUT: Deposit objects with all fields. RESPONSE: created object with code 200 or error with code 500",
        tags = {"deposits", "put"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Deposit.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> createDeposit(@RequestBody Deposit deposit) {
        try {
            return new ResponseEntity<Deposit>(depositInterface.createEntity(deposit), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path="/", produces = "application/json")
    @Operation(
        summary = "Returns all deposits",
        description = "RESPONSE: Deposits with code 200 or error with code 500",
        tags = {"deposits", "get"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Deposit.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> getDeposits() {
        try {
            return new ResponseEntity<List<Deposit>>(depositInterface.getAll(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @GetMapping(path="/{depositId}", produces = "application/json")
    @Operation(
        summary = "Returns deposit via ID",
        description = "RESPONSE: Deposit with code 200 or error with code 500",
        tags = {"deposits", "get"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Deposit.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> getDeposit(@PathVariable int depositId) {
        try {
            return new ResponseEntity<Deposit>(depositInterface.getEntity(depositId), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @PatchMapping(path="/{depositId}", produces = "application/json")
    @Operation(
        summary = "Updates deposit via ID",
        description = "INPUT: New deposit or fields with new values. RESPONSE: Updated or created (if deposit with that id not found) deposit with code 200 or error with code 500",
        tags = {"deposits", "patch"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Deposit.class), mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> updateDeposit(@PathVariable int depositId, @RequestBody Deposit deposit) throws IllegalAccessException, InvocationTargetException {
        try {
            return new ResponseEntity<Deposit>(depositInterface.updateEntity(depositId, deposit), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
    }

    @ResponseBody
    @DeleteMapping(path="/{depositId}", produces = "application/json")
    @Operation(
        summary = "Deletes deposit via ID",
        description = "RESPONSE: Code 200 or error with code 500",
        tags = {"deposits", "delete"}
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema())}),
        @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})
    })
    public ResponseEntity<?> deleteDeposit(@PathVariable int depositId) {
        try {
            depositInterface.deleteEntity(depositId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseHandler.badResponse(e.getMessage());
        }
        
    }
}
