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

import com.ip.bankmanager.entities.OrgLegalForm;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DataJpaTest
@ComponentScan(basePackages = {"com"})
public class OrgLegalFormServiceTests {

    @Autowired
    private OrgLegalFormService orgLegalFormService;

    @Test
    public void OrgLegalFormService_Create_ReturnCreatedOrgLegalForm() {
        OrgLegalForm olf = new OrgLegalForm();
        olf.setOrgLegalFormsName("Тест");

        OrgLegalForm savedOlf = orgLegalFormService.createEntity(olf);

        Assertions.assertThat(savedOlf).isNotNull();
        Assertions.assertThat(savedOlf.getOrgLegalFormsId()).isGreaterThan(0);
    }

    @Test
    public void OrgLegalFormService_GetAll_ReturnOrgLegalForms() {
        OrgLegalForm olf = new OrgLegalForm();
        olf.setOrgLegalFormsName("Тест");

        OrgLegalForm olf2 = new OrgLegalForm();
        olf2.setOrgLegalFormsName("Тест2");

        orgLegalFormService.createEntity(olf);
        orgLegalFormService.createEntity(olf2);

        List<OrgLegalForm> olfList = orgLegalFormService.getAll();

        Assertions.assertThat(olfList).isNotNull();
        Assertions.assertThat(olfList.size()).isEqualTo(2);
    }

    @Test
    public void OrgLegalFormService_FindById_ReturnOrgLegalForm() {
        OrgLegalForm olf = new OrgLegalForm();
        olf.setOrgLegalFormsName("Тест");

        olf = orgLegalFormService.createEntity(olf);

        try {
            OrgLegalForm olfReturn = orgLegalFormService.getEntity(olf.getOrgLegalFormsId());
            Assertions.assertThat(true).isTrue();
        } catch (RuntimeException e) {
            Assertions.assertThat(true).isFalse();
        }
    }
    
    @Test
    public void OrgLegalFormService_UpdateOrgLegalForm_ReturnOrgLegalFormNotNull() throws IllegalAccessException, InvocationTargetException {
        OrgLegalForm olf = new OrgLegalForm();
        olf.setOrgLegalFormsName("Тест");

        olf = orgLegalFormService.createEntity(olf);

        OrgLegalForm newOlf = new OrgLegalForm();
        newOlf.setOrgLegalFormsName("Тест2");

        OrgLegalForm updatedOlf = orgLegalFormService.updateEntity(olf.getOrgLegalFormsId(), newOlf);

        Assertions.assertThat(updatedOlf.getOrgLegalFormsName()).isEqualTo("Тест2");
    }

    @Test
    public void OrgLegalFormService_DeleteOrgLegalForm_ReturnException() {
        OrgLegalForm olf = new OrgLegalForm();
        olf.setOrgLegalFormsName("Тест");

        olf = orgLegalFormService.createEntity(olf);

        orgLegalFormService.deleteEntity(olf.getOrgLegalFormsId());

        try {
            OrgLegalForm olfReturn = orgLegalFormService.getEntity(olf.getOrgLegalFormsId());
            Assertions.assertThat(true).isFalse();
        } catch (RuntimeException e) {
            Assertions.assertThat(true).isTrue();
        }
    }
    
}
