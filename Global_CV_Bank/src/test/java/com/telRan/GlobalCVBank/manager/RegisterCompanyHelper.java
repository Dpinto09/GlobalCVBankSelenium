package com.telRan.GlobalCVBank.manager;

import com.telRan.GlobalCVBank.data.CompanyFormData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterCompanyHelper extends HelperBase {
    public RegisterCompanyHelper(WebDriver wd) {
        super(wd);
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
}
