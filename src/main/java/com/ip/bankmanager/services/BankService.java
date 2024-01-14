package com.ip.bankmanager.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import jakarta.annotation.Resource;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.stereotype.Service;
import com.ip.bankmanager.interfaces.BankInterface;
import com.ip.bankmanager.repositories.BankRepository;
import com.ip.bankmanager.validators.BeanUtilsBeanOverriden;
import com.ip.bankmanager.entities.Bank;


@Service
public class BankService implements BankInterface {
    @Resource
    private BankRepository bankRepository;

    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    @Override
    public Bank getEntity(int id) {
        return bankRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Bank createEntity(Bank entity) {
        return bankRepository.save(entity);
    }

    @Override
    public Bank updateEntity(int id, Bank newEntity) throws IllegalAccessException, InvocationTargetException {
        Bank oldEntity = bankRepository.findById(id).orElse(null);
        if (oldEntity == null) {
            return bankRepository.save(newEntity);
        }
        BeanUtilsBean beanOverriden = new BeanUtilsBeanOverriden();
        beanOverriden.copyProperties(oldEntity, newEntity);
        return bankRepository.save(oldEntity);
    }

    @Override
    public void deleteEntity(int id) {
        bankRepository.deleteById(id);
    }
}
