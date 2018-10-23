package com.telRan.GlobalCVBank.tests;

import com.telRan.GlobalCVBank.data.UserFormData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserTests extends TestBase {


    @Test
    public void testRegisterUserByRegisterButton() {
        clickOnButtonRegister();
        fillRegistrationUserForm(new UserFormData().setFirstName("David").setLastName("Pinto").setEmail(email).setPhone("+972585357284").setPassword(password).setConfirmPassword(password));

        Assert.assertTrue(wd.findElement(By.xpath("//div[@class='message-box']")).isDisplayed());

        clickOnButtonClose();

    }


    @Test
    public void testRegistrationUserByButtonLogin() {

        clickOnButtonLogin();
        clickOnCreateAccount();
        fillRegistrationUserForm(new UserFormData().setFirstName("David").setLastName("Pinto").setEmail(email).setPhone("+972585357284").setPassword("1234abcd").setConfirmPassword("1234abcd"));

        Assert.assertTrue(wd.findElement(By.xpath("//div[@class='message-box']")).isDisplayed());

        clickOnButtonClose();
    }

}
