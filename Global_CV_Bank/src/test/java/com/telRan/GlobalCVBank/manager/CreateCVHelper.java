package com.telRan.GlobalCVBank.manager;

import com.telRan.GlobalCVBank.data.CVFormData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateCVHelper extends HelperBase {
    public CreateCVHelper(WebDriver wd) {
        super(wd);
    }

    public void fillCV_Form(CVFormData CVFormData) throws InterruptedException {

        titleCV(CVFormData);

        contactInfo(CVFormData);

        description(CVFormData);

        Education(CVFormData);

        //testGetSkillList();
//        skills(CVFormData);

        projectsJobs(CVFormData);

        achievements(CVFormData);
        certifications(CVFormData);

        new Select(wd.findElement(By.xpath("//select[@ng-reflect-name='language_0']"))).selectByVisibleText(CVFormData.getLanguage());

        FootersLinks(CVFormData);
        FooterInfo(CVFormData);

    }

    public void skills(CVFormData CVFromData) {

        click(By.xpath("//u[contents(text(),'" + CVFromData.getSkills() + "')]"));

    }

    public void FooterInfo(CVFormData CVFormData) {
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

    public void FootersLinks(CVFormData CVFormData) {
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

    public void createCV_WithLogin() {

        click(By.xpath("//button[contains(text(),'Create')]"));
    }
}


