package com.telRan.GlobalCVBank.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    public WebDriver wd;
    private CreateCVHelper createCvHelper;
    private RegisterCompanyHelper registerCompanyHelper;
    private RegisterUserHelper registerUserHelper;
    private NavigationHelper navigationHelper;
    private LoginHelper loginHelper;
    private LogOutHelper logOutHelper;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("https://cv-app-test.herokuapp.com/");
        registerUserHelper = new RegisterUserHelper(wd);
        registerCompanyHelper = new RegisterCompanyHelper(wd);
        createCvHelper = new CreateCVHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        loginHelper = new LoginHelper(wd);
        logOutHelper = new LogOutHelper(wd);
    }

    public void stop() {
        wd.quit();
    }


    public void testGetSkillList() {
        int skillList = getSkillsCount();
        List<WebElement> skills = getSkillList();

        for (WebElement skill : skills) {
            String title = skill.getText();
            System.out.println(title);
        }
        System.out.println(skillList);
    }

    public List<WebElement> getSkillList() {
        return wd.findElements(By.cssSelector("u"));
    }

    public int getSkillsCount() {

        return wd.findElements(By.cssSelector("u")).size();


    }

    public RegisterUserHelper getRegisterUserHelper() {
        return registerUserHelper;
    }

    public RegisterCompanyHelper getRegisterCompanyHelper() {
        return registerCompanyHelper;
    }

    public CreateCVHelper getCreateCvHelper() {
        return createCvHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public LogOutHelper getLogOutHelper() {
        return logOutHelper;
    }
      /* public void addSkills(String webSkill) {

        click(By.xpath("//u[contains(text(),'" + webSkill + "'"));
        List<WebElement> elementSkills = getSkillList();
        for (WebElement skill : elementSkills) {

            String nameSkill = click(By.);
        }
    }*/
}
