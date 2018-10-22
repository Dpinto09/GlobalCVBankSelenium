package com.telRan.GlobalCVBank.tests;

import com.telRan.GlobalCVBank.data.CompanyFormData;
import com.telRan.GlobalCVBank.data.UserFormData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    String email = "dvd@gmail.com";
    String password = "1234abcd";
    WebDriver wd;

    @BeforeClass
    public void setUp(){

        start();
    }

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("https://cv-app-test.herokuapp.com/");
    }

    @AfterClass
    public void tearDown(){

        stop();
    }

    public void stop() {
        wd.quit();
    }

    public void click(By locator){

        wd.findElement(locator).click();
    }
        public void type(By locator, String text){

        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
        }

    public void clickOnButtonRegister() {

        click(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Register')]"));
    }

    public void clickOnButtonClose() {
        click(By.xpath("//button[@class='btn btn-close']"));
    }

    public void fillRegistrationUserForm(UserFormData userFormData) {
        type(By.xpath("//input[@id='firstName']"), userFormData.getFirstName());
        type(By.xpath("//input[@id='lastName']"), userFormData.getLastName());
        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='phone']"), userFormData.getPhone());
        type(By.xpath("//input[@id='password']"), userFormData.getPassword());
        type(By.xpath("//input[@id='password-confirm']"), userFormData.getConfirmPassword());
        click(By.xpath("//button[@type='submit']"));
    }

    public void clickOnCreateAccount() {

        click(By.xpath("//button[@class='btn btn-danger'][contains(text(),'Create')]"));
    }

    public void clickOnButtonLogin() {
        click(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Log in')]"));
    }

    public void fillRegistrationCompanyForm(CompanyFormData companyFormData) {


        type(By.xpath("//input[@id='companyName']"), companyFormData.getCompName());
        type(By.xpath("//input[@id='website']"), companyFormData.getWebsite());
        type(By.xpath("//input[@id='country']"), companyFormData.getCountry());
        type(By.xpath("//input[@id='city']"), companyFormData.getCity());
        type(By.xpath("//input[@id='street']"), companyFormData.getStreet());
        type(By.xpath("//input[@id='building']"), companyFormData.getBuilding());
        type(By.xpath("//input[@id='phone']"), companyFormData.getPostcode());
        type(By.xpath("//input[@id='phone-company']"), companyFormData.getPhone());
        type(By.xpath("//input[@id='firstName']"), companyFormData.getFirstName());
        type(By.xpath("//input[@id='lastName']"), companyFormData.getLastName());
        type(By.xpath("//input[@id='position']"), companyFormData.getPosition());
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), companyFormData.getPassword());
        type(By.xpath("//input[@id='confirmPass']"), companyFormData.getConfirmPassword());
        click(By.xpath("//button[@type='submit']"));
    }

    public void clickOnCompany() {
        click(By.xpath("//div[@class='right-heading']//h2"));
    }
    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void login() {

        clickOnButtonLogin();
        fillLoginFrom();
        submit();

        Assert.assertTrue(wd.findElement(By.xpath("//div[@class='message-box']")).isDisplayed());
        clickOnButtonClose();

    }

    public void submit() {

        click(By.xpath("//button[@type='submit']"));
    }

    public void fillLoginFrom() {

        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"),password);
    }

    public boolean loggedIn() {

        return isElementPresent(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Sign Out')]"));
    }

    public void singOut() {

        click(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Sign Out')]"));
    }
}