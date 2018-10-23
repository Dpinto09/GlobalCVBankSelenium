package com.telRan.GlobalCVBank.tests;

import com.telRan.GlobalCVBank.data.CVFormData;
import com.telRan.GlobalCVBank.data.CompanyFormData;
import com.telRan.GlobalCVBank.data.UserFormData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {

    String email = "dvd@gmail.com";
    String password = "1234abcd";
    WebDriver wd;

    @BeforeClass
    public void setUp() {

        start();
    }

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("https://cv-app-test.herokuapp.com/");
    }

    @AfterClass
    public void tearDown() {

        stop();
    }

    public void stop() {
        wd.quit();
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

    public void fillFormBirthday(By locator, String text) {
        wd.findElement(locator).click();
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
        type(By.xpath("//input[@id='email']"), email);
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

    public boolean isLoggedIn() {

        return isElementPresent(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Sign Out')]"));
    }

    public void submit() {

        click(By.xpath("//button[@type='submit']"));
    }

    public void fillLoginFrom() {

        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), password);
    }


    public void signOut() {
        click(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Sign Out')]"));
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

    public void createCV_WithLogin() {
        click(By.xpath("//i[@title='create CV']"));
    }

    public void fillCV_Form(CVFormData CVFormData) throws InterruptedException {

        titleCV(CVFormData);

        contactInfo(CVFormData);

        description(CVFormData);

        Education(CVFormData);

        List<WebElement> skillsLinks = new ArrayList<>();
        for (WebElement skill : skillsLinks) {
            wd.findElement(By.cssSelector("u")).getText();
            skillsLinks.add(skill);
        }
        System.out.println(skillsLinks);

        /*click(By.xpath("//u[contains(text(),'JavaScript')"));
        click(By.xpath("//u[contains(text(),'C#')"));
        click(By.xpath("//u[contains(text(),'C/C++')"));
        click(By.xpath("//u[contains(text(),'Linux')"));
        click(By.xpath("//u[contains(text(),'Windows')"));
        click(By.xpath("//u[contains(text(),'System Administration')"));
    */
        projectsJobs(CVFormData);

        achievements(CVFormData);
        certifications(CVFormData);

        new Select(wd.findElement(By.xpath("//select[@ng-reflect-name='language_0']"))).selectByVisibleText(CVFormData.getLanguage());

        footersLinks(CVFormData);
        footerInfo(CVFormData);

    }

    public void footerInfo(CVFormData CVFormData) {
        type(By.xpath("//textarea[@placeholder='recommendation']"), CVFormData.getRecommendations());
    }

    public void certifications(CVFormData CVFormData) {
        type(By.xpath("//div[@id='certifications']//div//textarea[@placeholder='description*']"), CVFormData.getCertificationDescription());
        type(By.xpath("//div[@id='certifications']//div//input[@placeholder='graduation year*']"), CVFormData.getCertificationYear());
    }

    public void achievements(CVFormData CVFormData) {
        type(By.xpath("//div[@id='achievements']//div//textarea[@placeholder='description*']"), CVFormData.getAchievementDescription());
        type(By.xpath("//div[@id='achievements']//div//input[@placeholder='graduation year*']"), CVFormData.getAchievementGraduationYear());
    }

    public void projectsJobs(CVFormData CVFormData) {
        type(By.xpath("//input[@placeholder='company*']"), CVFormData.getCompany());
        type(By.xpath("//input[@placeholder='position*']"), CVFormData.getPositionInCompany());
        type(By.xpath("//input[@placeholder='year from']"), CVFormData.getYearFrom());
        type(By.xpath("//input[@placeholder='year till']"), CVFormData.getYearTill());
        type(By.xpath("//textarea[@placeholder='project description']"), CVFormData.getProjectDescription());
    }

    public void footersLinks(CVFormData CVFormData) {
        type(By.xpath("//input[@placeholder='linkedin link']"), CVFormData.getLinkLinkedIn());
        type(By.xpath("//input[@placeholder='github']"), CVFormData.getLinkGitHub());
        type(By.xpath("//input[@placeholder='portfolio']"), CVFormData.getLinkPortfolio());
    }

    public void Education(CVFormData CVFormData) {
        type(By.xpath("//input[@placeholder='school/institution name*']"), CVFormData.getSchool());
        type(By.xpath("//input[@placeholder='degree*']"), CVFormData.getDegree());
        type(By.xpath("//div[@id='education']//div//input[@placeholder='graduation year*']"), CVFormData.getEducationGraduationYear());
        type(By.xpath("//textarea[@placeholder='description']"), CVFormData.getEducationDescription());
    }

    public void description(CVFormData CVFormData) {
        type(By.xpath("//input[@placeholder='choose preferable area']"), CVFormData.getPreferableArea());
        type(By.xpath("//input[@placeholder='choose preferable position']"), CVFormData.getPreferablePosition());
        type(By.xpath("//input[@placeholder='Salary from ($)']"), CVFormData.getSalaryFrom());
        type(By.xpath("//input[@placeholder='Salary till ($)']"), CVFormData.getSalaryTill());
    }

    public void contactInfo(CVFormData CVFormData) {
        type(By.xpath("//input[@placeholder='phone*']"), CVFormData.getPhone());
        type(By.xpath("//input[@placeholder='email*']"), CVFormData.getEmail());
        type(By.xpath("//input[@placeholder='residence']"), CVFormData.getAddress());
    }

    public void titleCV(CVFormData CVFormData) throws InterruptedException {
        click(By.xpath("//i[@class='fas fa-angle-double-down']"));
        type(By.xpath("//input[@placeholder='cv title*']"), CVFormData.getTitleCV());
        type(By.xpath("//input[@placeholder='first name*']"), CVFormData.getFirstName());
        type(By.xpath("//input[@placeholder='last name*']"), CVFormData.getLastName());
        Thread.sleep(3000);
        fillFormBirthday(By.xpath("//input[@ng-reflect-name='birthday']"), CVFormData.getBirthday());
        type(By.xpath("//textarea[@id='summary']"), CVFormData.getSummary());
        type(By.xpath("//textarea[@id='about']"), CVFormData.getAbout());
    }

    public void createCV_WithoutLogin() {
        click(By.xpath("//button[contains(text(),'Create')]"));
    }
}