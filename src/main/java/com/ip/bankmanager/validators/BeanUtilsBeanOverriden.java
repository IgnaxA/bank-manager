package com.ip.bankmanager.validators;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtilsBean;

public class BeanUtilsBeanOverriden extends BeanUtilsBean {
    @Override
    public void copyProperty(Object dest, String name, Object value) throws IllegalAccessException, InvocationTargetException {
        if (value == null) return;
        super.copyProperty(dest, name, value);
    }
}
