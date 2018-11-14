package com.telRan.GlobalCVBank.tests;


import com.telRan.GlobalCVBank.model.CompanyFormData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateAccountCompany extends TestBase {

   /* @BeforeMethod
    public void ensurePreconditions() {

        if (!isLogOut()) {

            logOut();
        }
    }*/


    @Test
    public void testCreateNewCompanyAccountByButtonRegister() throws InterruptedException {

        clickOnButtonRegister();
        if (!isInFillCompany()) {
            click(By.xpath("//div[@class='right-heading']"));
            Thread.sleep(3000);
        }
        fillCreateNewCompanyAccount(new CompanyFormData().setCompanyName("Tel Ran").setWebsite("www.telRan.com").setCountry("Russia").
                setCity("Moscu").setStreet("Vladimir Putin").setBuilding("38").setPostcode("75008").setPhone("0585162383")
                .setFirstName("David").setLastName("Pinto").setPosition("QA").setEmail(emailCreate).setPassword(password).setRepeatPassword(password));
    }

    @Test
    public void testCreateNewCompanyByButtonLogin() throws InterruptedException {

        initCreateAccountByLogin();
        if (!isInFillCompany()) {
            click(By.xpath("//div[@class='right-heading']"));
            Thread.sleep(3000);
        }
        fillCreateNewCompanyAccount(new CompanyFormData().setCompanyName("Tel Ran").setWebsite("www.telRan.com").setCountry("Russia")
                .setCity("Moscu").setStreet("Vladimir Putin").setBuilding("38").setPostcode("75008").setPhone("0585162383").
                        setFirstName("David").setLastName("Pinto").setPosition("QA").setEmail(emailCreate).setPassword(password).setRepeatPassword(password));

    }




}
