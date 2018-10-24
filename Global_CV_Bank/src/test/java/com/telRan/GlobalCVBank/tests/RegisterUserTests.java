package com.telRan.GlobalCVBank.tests;

import com.telRan.GlobalCVBank.data.UserFormData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserTests extends TestBase {
    String email = "dvd+" + System.currentTimeMillis() + "@gmail.com";
    String password = "1234abcd";
    @Test
    public void testRegisterUserByRegisterButton() {
        app.getNavigationHelper().clickOnButtonRegister();
        app.getRegisterUserHelper().fillRegistrationUserForm(new UserFormData().setFirstName("David").setLastName("Pinto").setEmail(email).setPhone("+972585357284").setPassword(password).setConfirmPassword(password));

        Assert.assertTrue(app.wd.findElement(By.xpath("//div[@class='message-box']")).isDisplayed());

        app.getNavigationHelper().clickOnButtonClose();

    }


    @Test
    public void testRegistrationUserByButtonLogin() {

        app.getNavigationHelper().clickOnButtonLogin();
        app.getNavigationHelper().clickOnCreateAccount();
        app.getRegisterUserHelper().fillRegistrationUserForm(new UserFormData().setFirstName("David").setLastName("Pinto").setEmail(email).setPhone("+972585357284").setPassword("1234abcd").setConfirmPassword("1234abcd"));

        Assert.assertTrue(app.wd.findElement(By.xpath("//div[@class='message-box']")).isDisplayed());

        app.getNavigationHelper().clickOnButtonClose();
    }

}
