package com.ip.bankmanager.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.stereotype.Service;

import com.ip.bankmanager.entities.Client;
import com.ip.bankmanager.interfaces.ClientInterface;
import com.ip.bankmanager.repositories.ClientRepository;
import com.ip.bankmanager.validators.BeanUtilsBeanOverriden;

import jakarta.annotation.Resource;

@Service
public class ClientService implements ClientInterface {
    @Resource
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getEntity(int id) {
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Client createEntity(Client entity) {
        return clientRepository.save(entity);
    }

    @Override
    public Client updateEntity(int id, Client newEntity) throws IllegalAccessException, InvocationTargetException {
        Client oldEntity = clientRepository.findById(id).orElse(null);
        if (oldEntity == null) {
            return clientRepository.save(newEntity);
        }
        BeanUtilsBean beanOverriden = new BeanUtilsBeanOverriden();
        beanOverriden.copyProperties(oldEntity, newEntity);
        return clientRepository.save(oldEntity);
    }

    @Override
    public void deleteEntity(int id) {
        clientRepository.deleteById(id);
    }
}