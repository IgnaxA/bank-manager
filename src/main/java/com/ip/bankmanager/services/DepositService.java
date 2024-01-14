package com.ip.bankmanager.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.stereotype.Service;

import com.ip.bankmanager.entities.Deposit;
import com.ip.bankmanager.interfaces.DepositInterface;
import com.ip.bankmanager.repositories.DepositRepository;
import com.ip.bankmanager.validators.BeanUtilsBeanOverriden;

import jakarta.annotation.Resource;

@Service
public class DepositService implements DepositInterface {
    @Resource
    private DepositRepository depositRepository;

    @Override
    public List<Deposit> getAll() {
        return depositRepository.findAll();
    }

    @Override
    public Deposit getEntity(int id) {
        return depositRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Deposit createEntity(Deposit entity) {
        return depositRepository.save(entity);
    }

    @Override
    public Deposit updateEntity(int id, Deposit newEntity) throws IllegalAccessException, InvocationTargetException {
        Deposit oldEntity = depositRepository.findById(id).orElse(null);
        if (oldEntity == null) {
            return depositRepository.save(newEntity);
        }
        BeanUtilsBean beanOverriden = new BeanUtilsBeanOverriden();
        beanOverriden.copyProperties(oldEntity, newEntity);
        return depositRepository.save(oldEntity);
    }

    @Override
    public void deleteEntity(int id) {
        depositRepository.deleteById(id);
    }
    
}
