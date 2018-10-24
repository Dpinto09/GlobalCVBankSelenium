package com.telRan.GlobalCVBank.manager;

import com.telRan.GlobalCVBank.data.UserFormData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterUserHelper extends HelperBase {

    public RegisterUserHelper(WebDriver wd) {
        super(wd);
    }

    public void fillFormBirthday(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).sendKeys(text);
    }

    public void fillRegistrationUserForm(UserFormData userFormData) {
        type(By.xpath("//input[@id='firstName']"), userFormData.getFirstName());
        type(By.xpath("//input[@id='lastName']"), userFormData.getLastName());
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='phone']"), userFormData.getPhone());
        type(By.xpath("//input[@id='password']"), userFormData.getPassword());
        type(By.xpath("//input[@id='password-confirm']"), userFormData.getConfirmPassword());
        click(By.xpath("//button[@type='submit']"));
    }
}
