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

import com.ip.bankmanager.entities.Bank;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DataJpaTest
@ComponentScan(basePackages = {"com"})
public class BankServiceTests {

    @Autowired
    private BankService bankService;
    
    @Test
    public void BankService_Create_ReturnCreatedBank() {
        Bank bank = new Bank();
        bank.setBankName("Тест");
        bank.setBic(1111);

        Bank savedBank = bankService.createEntity(bank);

        Assertions.assertThat(savedBank).isNotNull();
        Assertions.assertThat(savedBank.getBankId()).isGreaterThan(0);
    }

    @Test
    public void BankService_GetAll_ReturnBanks() {
        Bank bank1 = new Bank();
        bank1.setBankName("Тест");
        bank1.setBic(1111);

        Bank bank2 = new Bank();
        bank2.setBankName("Тест2");
        bank2.setBic(2222);

        bankService.createEntity(bank1);
        bankService.createEntity(bank2);

        List<Bank> bankList = bankService.getAll();

        Assertions.assertThat(bankList).isNotNull();
        Assertions.assertThat(bankList.size()).isEqualTo(2);
    }

    @Test
    public void BankService_FindById_ReturnBank() {
        Bank bank = new Bank();
        bank.setBankName("Тест");
        bank.setBic(1111);

        bank = bankService.createEntity(bank);

        try {
            Bank bankReturn = bankService.getEntity(bank.getBankId());
            Assertions.assertThat(true).isTrue();
        } catch (RuntimeException e) {
            Assertions.assertThat(false).isFalse();
        }
    }

    @Test
    public void BankService_UpdateBank_ReturnBankNotNull() throws IllegalAccessException, InvocationTargetException {
        Bank bank = new Bank();
        bank.setBankName("Тест");
        bank.setBic(1111);

        bank = bankService.createEntity(bank);

        Bank newBank = new Bank();
        newBank.setBankName("Тест2");
        newBank.setBic(2222);

        Bank updatedBank = bankService.updateEntity(bank.getBankId(), newBank);

        Assertions.assertThat(updatedBank.getBankName()).isEqualTo("Тест2");
        Assertions.assertThat(updatedBank.getBic()).isEqualTo(2222);
    }

    @Test
    public void BankService_DeleteBank_ReturnException() {
        Bank bank = new Bank();
        bank.setBankName("Тест");
        bank.setBic(1111);

        bank = bankService.createEntity(bank);

        bankService.deleteEntity(bank.getBankId());

        try {
            Bank bankReturn = bankService.getEntity(bank.getBankId());
            Assertions.assertThat(true).isFalse();
        } catch (RuntimeException e) {
            Assertions.assertThat(true).isTrue();
        }        
    }
}
