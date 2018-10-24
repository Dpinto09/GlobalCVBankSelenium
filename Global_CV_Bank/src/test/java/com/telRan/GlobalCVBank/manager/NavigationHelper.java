package com.telRan.GlobalCVBank.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NavigationHelper extends HelperBase{
    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnButtonRegister() {

        click(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Register')]"));
    }

    public void clickOnButtonClose() {
        click(By.xpath("//button[@class='btn btn-close']"));
    }

    public void clickOnCreateAccount() {

        click(By.xpath("//button[@class='btn btn-danger'][contains(text(),'Create')]"));
    }

    public void clickOnButtonLogin() {
        click(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Log in')]"));
    }

    public void clickOnCompany() {
        click(By.xpath("//div[@class='right-heading']//h2"));
    }





    public boolean homePage() {

        return isElementPresent(By.xpath("//h1[@class='d-flex justify-content-center']//span[2]"));
    }

    public void addEducation() {

        click(By.xpath("//button[@title='Add Education']"));
    }

    public void removeEducation() {

        click(By.xpath("//button[@title='Remove Education']//i[@class='fas fa-minus fa-2x']"));
    }

    public void addLanguage() {

        click(By.xpath("//button[@title='Add Language']//i[@class='fas fa-plus fa-2x']"));
    }

    public void removeLanguage() {

        click(By.xpath("//button[@title='Remove Language']"));
    }

    public void addAchievement() {

        click(By.xpath("//button[@title='Add Achivement']//i[@class='fas fa-plus fa-2x']"));
    }

    public void removeAchievement() {

        click(By.xpath("//button[@title='Remove Achivement']"));
    }

    public void addCertification() {
        click(By.xpath("//button[@title='Add Certification']"));
    }

    public void removeCertification() {
        click(By.xpath("//button[@title='Remove Certification']"));
    }

    public void addJob() {

        click(By.xpath("//button[@title='Add Project/Job']//i[@class='fas fa-plus fa-2x']"));
    }

    public void removeJob() {

        click(By.xpath("//button[@title='Remove Project/Job']//i[@class='fas fa-minus fa-2x']"));
    }
    public void fillLoginFrom() {

        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }
}
