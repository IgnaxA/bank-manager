package com.ip.bankmanager.services;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.stereotype.Service;

import com.ip.bankmanager.entities.OrgLegalForm;
import com.ip.bankmanager.interfaces.OrgLegalFormInterface;
import com.ip.bankmanager.repositories.OrgLegalFormRepository;
import com.ip.bankmanager.validators.BeanUtilsBeanOverriden;

import jakarta.annotation.Resource;

@Service
public class OrgLegalFormService implements OrgLegalFormInterface {
    @Resource
    private OrgLegalFormRepository orgLegalFormRepository;

    @Override
    public List<OrgLegalForm> getAll() {
        return orgLegalFormRepository.findAll();
    }

    @Override
    public OrgLegalForm getEntity(int id) {
        return orgLegalFormRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public OrgLegalForm createEntity(OrgLegalForm entity) {
        return orgLegalFormRepository.save(entity);
    }

    @Override
    public OrgLegalForm updateEntity(int id, OrgLegalForm newEntity) throws IllegalAccessException, InvocationTargetException {
        OrgLegalForm oldEntity = orgLegalFormRepository.findById(id).orElse(null);
        if (oldEntity == null) {
            return orgLegalFormRepository.save(newEntity);
        }
        BeanUtilsBean beanOverriden = new BeanUtilsBeanOverriden();
        beanOverriden.copyProperties(oldEntity, newEntity);
        return orgLegalFormRepository.save(oldEntity);
    }

    @Override
    public void deleteEntity(int id) {
        orgLegalFormRepository.deleteById(id);
    }
}
