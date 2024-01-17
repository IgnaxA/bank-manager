package com.ip.bankmanager.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import com.ip.bankmanager.entities.Deposit;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DataJpaTest
@ComponentScan(basePackages = {"com"})
public class DepositServiceTests {
    @Autowired
    private DepositService depositService;

    @Test
    public void DepositService_Create_ReturnCreatedDeposit() {
        Deposit deposit = new Deposit();
        deposit.setBankId(1);
        deposit.setClientId(1);

        Deposit savedDeposit = depositService.createEntity(deposit);

        Assertions.assertThat(savedDeposit).isNotNull();
        Assertions.assertThat(savedDeposit.getDepositId()).isGreaterThan(0);
    }

    @Test
    public void DepositService_GetAll_ReturnDeposits() {
        Deposit deposit = new Deposit();
        deposit.setBankId(1);
        deposit.setClientId(1);

        Deposit deposit2 = new Deposit();
        deposit.setBankId(2);
        deposit.setClientId(2);

        depositService.createEntity(deposit);
        depositService.createEntity(deposit2);

        List<Deposit> depositList = depositService.getAll();
        
        Assertions.assertThat(depositList).isNotNull();
        Assertions.assertThat(depositList.size()).isEqualTo(2);
    }

    @Test
    public void DepositService_FindById_ReturnDeposit() {
        Deposit deposit = new Deposit();
        deposit.setBankId(1);
        deposit.setClientId(1);

        deposit = depositService.createEntity(deposit);

        try {
            Deposit depositReturn = depositService.getEntity(deposit.getDepositId());
            Assertions.assertThat(true).isTrue();
        } catch (RuntimeException e) {
            Assertions.assertThat(false).isFalse();
        }
    }

    @Test
    public void DepositService_UpdateDeposit_ReturnDepositNotNull() throws IllegalAccessException, InvocationTargetException {
        Deposit deposit = new Deposit();
        deposit.setBankId(1);
        deposit.setClientId(1);

        deposit = depositService.createEntity(deposit);

        Deposit newDeposit = new Deposit();
        deposit.setBankId(2);
        deposit.setClientId(2);

        Deposit updatedDeposit = depositService.updateEntity(deposit.getDepositId(), newDeposit);

        Assertions.assertThat(updatedDeposit.getBankId()).isEqualTo(2);
        Assertions.assertThat(updatedDeposit.getClientId()).isEqualTo(2);
    }

    @Test
    public void DepositService_DeleteDeposit_ReturnException() {
        Deposit deposit = new Deposit();
        deposit.setBankId(1);
        deposit.setClientId(1);

        deposit = depositService.createEntity(deposit);

        depositService.deleteEntity(deposit.getDepositId());

        try {
            Deposit depositReturn = depositService.getEntity(deposit.getDepositId());
            Assertions.assertThat(true).isFalse();
        } catch (RuntimeException e) {
            Assertions.assertThat(true).isTrue();
        }
    }
}
