package com.telRan.GlobalCVBank.tests;

import com.telRan.GlobalCVBank.model.UserFormData;
import org.testng.annotations.Test;

public class CreateAccountUser extends TestBase {

    @Test
    public void testCreateNewUserAccountByButtonRegister(){

        clickOnButtonRegister();
        fillCreateNewUserAccount(new UserFormData().setFirstName("David").setLastName("Pinto").setEmail(emailCreate).setPhone("0585162383").setPassword(password).setRepeatPassword(password));
    }

    @Test
    public void testCreateNewUserAccountByButtonLogin(){

        initCreateAccountByLogin();
        fillCreateNewUserAccount(new UserFormData());
        clickOnProceed();
        clickOnButtonClose();
    }

}
