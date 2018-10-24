package com.telRan.GlobalCVBank.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginHelper extends HelperBase {

    String email = "dvd@gmail.com";
    String password = "1234abcd";

    public LoginHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isLoggedIn() {

        return isElementPresent(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Sign Out')]"));
    }

    public void login() {

        clickOnButtonLogin();
        fillLoginFrom();

        Assert.assertTrue(wd.findElement(By.xpath("//div[@class='message-box']")).isDisplayed());
        clickOnButtonClose();

    }

    public void clickOnButtonLogin() {
        click(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Log in')]"));
    }

    public void fillLoginFrom() {

        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
        click(By.xpath("//button[@type='submit']"));
    }

    public void clickOnButtonClose() {
        click(By.xpath("//button[@class='btn btn-close']"));
    }

}
