package com.telRan.GlobalCVBank.tests;

import com.telRan.GlobalCVBank.data.CompanyFormData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterCompanyTests extends TestBase {


    @Test
    public void testRegisterCompanyByButtonRegister() {

        clickOnButtonRegister();
        clickOnCompany();
        fillRegistrationCompanyForm(new CompanyFormData().setCompName("Les BgS").setWebsite("https://www.bgs.com").setCountry("Israel").setCity("Ashkelon").setStreet("Bar Kokhva").setBuilding("209").
                setPostcode("750330").setPhone("+972545100000").setFirstName("David").setLastName("Pinto").setPosition("QA Automation").setEmail(email).setPassword("1234abcd").setConfirmPassword("1234abcd"));

        Assert.assertTrue(wd.findElement(By.xpath("//div[@class='message-box']")).isDisplayed());

        clickOnButtonClose();
    }

}
