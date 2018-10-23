package com.telRan.GlobalCVBank.tests;

import com.telRan.GlobalCVBank.data.CVFormData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCVTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

        if (!homePage()) {

            homePage();
        }

    }

    @Test

    public void testCreateCV_ByButton() throws InterruptedException {

        createCV_WithoutLogin();
        fillCV_Form(new CVFormData().setTitleCV("QA Automation").setFirstName("David").setLastName("Pinto").setBirthday("21021992").setAbout("I want to be like Mike").
                setPhone("+972585162383").setEmail(email).setAddress("Bar Kokhva 209, Ashkelon").setPreferableArea("In my Saloon").setPreferablePosition("Sitting with a beer").
                setSalaryFrom("1400").setSalaryTill("2400").setSchool("My house").setDegree("Master").setEducationGraduationYear("2012").setEducationDescription("I was in front of the TV all the time").
                setCompany("Father & Mother").setPositionInCompany("In the sofa").setYearFrom("1992").setYearTill("2018").
                setAchievementDescription("1st place in doing nothing").setAchievementGraduationYear("1994").setLanguage("French").setLanguage("English").setLanguage("Spanish"));
    }


    @BeforeMethod
    public void Preconditions() {

        if (!isLoggedIn()) {

            login();
        }


    }

    @Test
    public void testCreateCV_WithLogin() throws InterruptedException {

        createCV_WithLogin();
        fillCV_Form(new CVFormData().setTitleCV("").setFirstName("").setLastName("").setBirthday("").setSummary("").setAbout("").
                setPhone("").setEmail(email).setAddress("").setPreferableArea("").setPreferablePosition("").
                setSalaryFrom("").setSalaryTill("").setSchool("").setDegree("").setEducationGraduationYear("").setEducationDescription("").
                setSkills("").setCompany("").setPositionInCompany("").setYearFrom("").setYearTill("").setProjectDescription("").
                setAchievementDescription("").setAchievementGraduationYear("").setCertificationDescription("").setCertificationYear("").
                setLanguage("").setLinkLinkedIn("").setLinkGitHub("").setLinkPortfolio("").setRecommendations(""));


    }


}
