package com.telRan.GlobalCVBank.tests;

import com.telRan.GlobalCVBank.model.CompanyFormData;
import com.telRan.GlobalCVBank.model.UserFormData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    String emailCreate = "dvd+" + System.currentTimeMillis() + "@gmail.com";
    String email = "dvd@gmail.com";
    String password = "1234abcd";
    WebDriver wd;

    @BeforeClass
    public void setUp() {

        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://cv-app-test.herokuapp.com/");
    }

    @AfterClass
    public void tearDown() {

        wd.quit();
    }


    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {

        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void waitAndClick(int millis, By locator) throws InterruptedException {

        Thread.sleep(millis);

        click(locator);

    }

    public void escape() {

        Actions action = new Actions(wd);

        action.sendKeys(Keys.ESCAPE).build().perform();

    }

    public boolean isElementPresent(By locator) {

        try {

            wd.findElement(locator);

            return true;

        } catch (NoSuchElementException e) {

            return false;

        }

    }

    public void fillCreateAccountForm(String firstName, String lastName, String email, String phone, String password, String repeatPassword) {
        type(By.xpath("//input[@formcontrolname='firstName']"), firstName);
        type(By.xpath("//input[@formcontrolname='lastName']"), lastName);
        type(By.xpath("//input[@formcontrolname='email']"), email);
        type(By.xpath("//input[@formcontrolname='phone']"), phone);
        type(By.xpath("//input[@formcontrolname='firstName']"), password);
        type(By.xpath("//input[@formcontrolname='firstName']"), repeatPassword);
    }

    public void clickOnProceed() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void clickOnButtonClose() {
        click(By.xpath("//button[@class='btn btn-close']"));
    }

    public void clickOnButtonRegister() {
        click(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Register')]"));

    }

    public void initCreateAccountByLogin() {
        click(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Log in')]"));
        click(By.xpath("//button[@class='btn btn-danger'][contains(text(),'Create')]"));
    }

    public void fillCreateNewUserAccount(UserFormData userFormData) {
        fillCreateAccountForm(userFormData.getFirstName(), userFormData.getLastName(), userFormData.getEmail(), userFormData.getPhone(), userFormData.getPassword(), userFormData.getRepeatPassword());
        clickOnProceed();
        clickOnButtonClose();
    }

    public void fillCreateNewCompanyAccount(CompanyFormData companyFormData) throws InterruptedException {

        fillCompanyDetails(companyFormData.getCompanyName(), companyFormData.getWebsite(), companyFormData.getCountry(), companyFormData.getCity(), companyFormData.getStreet(), companyFormData.getBuilding(), companyFormData.getPostcode(), companyFormData.getPhone());

        fillApplicantDetails(companyFormData.getFirstName(), companyFormData.getLastName(), companyFormData.getPosition(), companyFormData.getEmail(), companyFormData.getPassword(), companyFormData.getRepeatPassword());
    }

    public void fillApplicantDetails(String firstName, String lastName, String position, String email, String password, String repeatPassword) throws InterruptedException {
        type(By.xpath("//input[@formcontrolname='firstName']"), firstName);
        type(By.xpath("//input[@formcontrolname='lastName']"), lastName);
        type(By.xpath("//input[@formcontrolname='position']"), position);
        type(By.xpath("//input[@formcontrolname='email']"), email);
        type(By.xpath("//input[@formcontrolname='password']"), password);
        type(By.xpath("//input[@formcontrolname='confirmPass']"), repeatPassword);
        clickOnProceed();
        Thread.sleep(3000);
        clickOnButtonClose();

    }

    public void fillCompanyDetails(String companyName, String website, String country, String city, String street, String building, String postcode, String phone) {
        type(By.xpath("//input[@formcontrolname='companyName']"), companyName);
        type(By.xpath("//input[@formcontrolname='website']"), website);
        type(By.xpath("//input[@formcontrolname='country']"), country);
        type(By.xpath("//input[@formcontrolname='cityTown']"), city);
        type(By.xpath("//input[@formcontrolname='street']"), street);
        type(By.xpath("//input[@formcontrolname='houseBuilding']"), building);
        type(By.xpath("//input[@formcontrolname='postcode']"), postcode);
        type(By.xpath("//input[@formcontrolname='phone']"), phone);
    }

    public boolean isInFillCompany() {

        return isElementPresent(By.xpath("//*[contains(text(),'company details')]"));
    }

    public void logOut() {
        click(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Sign Out')]"));
    }

    public boolean isLogOut() {

        return isElementPresent(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Sign Out')]"));
    }

    public void addButtonInCV(String section) {

        click(By.xpath("//button[@title='Add " + section + "']"));
    }

    public void removeButtonInCV(String section) {

        click(By.xpath("//button[@title='Remove " + section + "']"));
    }

    public void fillCVForm(String cvTitle, String firstName, String lastName, String birthday, String summary, String about,
                           String phone, String email, String residence, String preferableArea, String preferablePosition,
                           String salaryFrom, String salaryTill, String school, String degree, String schoolGraduationYear,
                           String educationDescription, String company, String position, String yearFrom, String yearTill,
                           String jobDescription, String achievementDescription, String achievementYear, String certificationDescription, String certificationYear, int countLanguage, String languageName,
                           String linkedLink, String gitHubLink, String portfolioLink, String recommendations) {

        titleCV(cvTitle, firstName, lastName, birthday, summary, about);
        contactInfoCV(phone, email, residence);
        descriptionCV(preferableArea, preferablePosition, salaryFrom, salaryTill);
        educationCV(school, degree, schoolGraduationYear, educationDescription);
        //Skills
        jobs(company, position, yearFrom, yearTill, jobDescription);
        achievements(achievementDescription,achievementYear);
        certifications(certificationDescription,certificationYear);
        languages(countLanguage, languageName);
        footerLinks(linkedLink, gitHubLink, portfolioLink);
        footerInfo(recommendations);
    }

    public void footerInfo(String recommendations) {

        type(By.xpath("//textarea[@placeholder='recommendation']"),recommendations);

    }

    public void footerLinks(String linkedLink, String gitHubLink, String portfolioLink) {

        type(By.xpath("//input[@placeholder='linkedin link']"), linkedLink);
        type(By.xpath("//input[@placeholder='github']"), gitHubLink);
        type(By.xpath("//input[@placeholder='portfolio']"), portfolioLink);
    }

    public void languages(int count, String lang) {

        for (int i = 0; i >= count; i++) {
            click(By.xpath("//select[@class='ng-pristine ng-valid ng-touched']"));
            Select language = new Select(wd.findElement(By.xpath("//select[@class='ng-pristine ng-valid ng-touched']")));
            language.selectByVisibleText(lang);
            addButtonInCV("Language");


        }
    }

    public void certifications(String certificationDescription, String certificationYear) {

        type(By.xpath("//*[@ng-reflect-name='certification_0']"), certificationDescription);
        type(By.xpath("//input[@ng-reflect-name='certification_date_end_0']"),certificationYear);
    }

    public void achievements(String achievementDescription, String achievementYear) {
        type(By.xpath("//*[@ng-reflect-name='achievement_0']"), achievementDescription);
        type(By.xpath("//input[@ng-reflect-name='achievement_date_end_0']"),achievementYear);
    }

    public void jobs(String company, String position, String yearFrom, String yearTill, String jobDescription) {
        type(By.xpath("//input[@placeholder='company*']"), company);
        type(By.xpath("//input[@placeholder='position*']"), position);
        type(By.xpath("//input[@placeholder='year fromm']"), yearFrom);
        type(By.xpath("//input[@placeholder='year till']"), yearTill);
        type(By.xpath("//input[@placeholder='project description']"), jobDescription);

    }

    public void descriptionCV(String preferableArea, String preferablePosition, String salaryFrom, String salaryTill) {
        type(By.xpath("//input[@placeholder='choose preferable area']"), preferableArea);
        type(By.xpath("//input[@placeholder='choose preferable position']"), preferablePosition);
        type(By.xpath("//input[@placeholder='Salary from ($)']"), salaryFrom);
        type(By.xpath("//input[@placeholder='Salary till ($)']"), salaryTill);
    }

    public void educationCV(String school, String degree, String schoolGraduationYear, String description) {
        type(By.xpath("//input[@placeholder='school/institution name*']"), school);
        type(By.xpath("//input[@placeholder='degree*']"), degree);
        type(By.xpath("//input[@placeholder='graduation year*']"), schoolGraduationYear);
        type(By.xpath("\"//*[@ng-reflect-name='edu_description_0']"), description);
    }

    public void contactInfoCV(String phone, String email, String residence) {
        type(By.xpath("//input[@placeholder='phone*']"), phone);
        type(By.xpath("//input[@placeholder='email*']"), email);
        type(By.xpath("//input[@placeholder='residence']"), residence);
    }

    public void titleCV(String cvTitle, String firstName, String lastName, String birthday, String summary, String about) {
        type(By.xpath("//input[@placeholder='cv title*']"), cvTitle);
        type(By.xpath("//input[@placeholder='first name*']"), firstName);
        type(By.xpath("//input[@placeholder='last name*']"), lastName);
        type(By.xpath("//input[@placeholder='birthday']"), birthday);
        type(By.xpath("//input[@placeholder='summary*']"), summary);
        type(By.xpath("//input[@placeholder='about*']"), about);
    }

    public void initCreateCV() {
        click(By.xpath("//button[contains(text(),'Create')]"));
        if (!isCVReleased()) {
            click(By.xpath("//i[@class='fas fa-angle-double-down']"));
        }
    }

    public boolean isCVReleased() {

        return isElementPresent(By.xpath("//input[@placeholder='cv title*']"));
    }

    public void selectBlueCV() {
        click(By.xpath("//li//div[1]//img[1]"));
    }

    public void selectGreenCV() {

        click(By.xpath("//li//div[2]//img[1]"));
    }
}