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

import com.ip.bankmanager.entities.Client;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ComponentScan(basePackages = {"com"})
public class ClientServiceTests {
    @Autowired
    private ClientService clientService;

    @Test
    public void ClientService_Create_ReturnCreatedClient() {
        Client client = new Client();
        client.setClientName("Тест");
        client.setClientShortName("T");
        client.setAddress("Тест.Тест");
        client.setOrgLegalFormId(1);

        Client savedClient = clientService.createEntity(client);

        Assertions.assertThat(savedClient).isNotNull();
        Assertions.assertThat(savedClient.getClientId()).isGreaterThan(0);
    }

    @Test
    public void ClientService_GetAll_ReturnClients() {
        Client client = new Client();
        client.setClientName("Тест");
        client.setClientShortName("T");

        Client client2 = new Client();
        client.setClientName("Тест2");
        client.setClientShortName("T2");

        clientService.createEntity(client);
        clientService.createEntity(client2);

        List<Client> clientList = clientService.getAll();

        Assertions.assertThat(clientList).isNotNull();
        Assertions.assertThat(clientList.size()).isEqualTo(2);
    }

    @Test
    public void ClientService_FindById_ReturnClient() {
        Client client = new Client();
        client.setClientName("Тест");
        client.setClientShortName("T");
        client.setAddress("Тест.Тест");
        client.setOrgLegalFormId(1);

        client = clientService.createEntity(client);

        try {
            Client clientReturn = clientService.getEntity(client.getClientId());
            Assertions.assertThat(true).isTrue();
        } catch (RuntimeException e) {
            Assertions.assertThat(true).isFalse();
        }
    }

    @Test
    public void ClientService_UpdateClient_ReturnClientNotNull() throws IllegalAccessException, InvocationTargetException {
        Client client = new Client();
        client.setClientName("Тест");
        client.setClientShortName("T");
        client.setAddress("Тест.Тест");
        client.setOrgLegalFormId(1);

        client = clientService.createEntity(client);

        Client newClient = new Client();
        newClient.setClientName("Тест2");
        newClient.setClientShortName("Т2");

        Client updatedClient = clientService.updateEntity(client.getClientId(), newClient);

        Assertions.assertThat(updatedClient.getClientName()).isEqualTo("Тест2");
        Assertions.assertThat(updatedClient.getClientShortName()).isEqualTo("Т2");
    }

    @Test
    public void ClientService_DeleteService_ReturnException() {
        Client client = new Client();
        client.setClientName("Тест");
        client.setClientShortName("T");
        client.setAddress("Тест.Тест");
        client.setOrgLegalFormId(1);

        client = clientService.createEntity(client);

        clientService.deleteEntity(client.getClientId());

        try {
            Client clientReturn = clientService.getEntity(client.getClientId());
            Assertions.assertThat(true).isFalse();
        } catch (RuntimeException e) {
            Assertions.assertThat(true).isTrue();
        }
    }

}
