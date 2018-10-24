package com.telRan.GlobalCVBank.manager;

import com.telRan.GlobalCVBank.data.CVFormData;
import com.telRan.GlobalCVBank.data.CompanyFormData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {

    String email = "dvd@gmail.com";
    String password = "1234abcd";
    WebDriver wd;


    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {

        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {

            wd.findElement(locator).click();
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void fillFormBirthday(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).sendKeys(text);
    }


}



