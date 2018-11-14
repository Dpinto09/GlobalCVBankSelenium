package com.telRan.GlobalCVBank.tests;

import com.telRan.GlobalCVBank.model.CVFormData;
import org.testng.annotations.Test;

public class CreateCVTests extends TestBase {

    @Test
    public void testCreateCVWithoutLogin(CVFormData CVFormData) {

        initCreateCV();
        fillCVForm(CVFormData.setCvTitle(), CVFormData.setFirstName(), CVFormData.setLastName(), CVFormData.setBirthday(),
                CVFormData.setSummary(), CVFormData.setAbout(), CVFormData.setPhone(), CVFormData.setEmail(), CVFormData.setResidence(),
                CVFormData.getPreferableArea(), CVFormData.setPreferablePosition(),CVFormData.setSalaryFrom(), CVFormData.setSalaryTill(),
                CVFormData.setSchool(), CVFormData.setDegree(), CVFormData.setSchoolGraduationYear(), CVFormData.setDescription(),
                CVFormData.setCompany(), CVFormData.setPosition(), CVFormData.setYearFrom(), CVFormData.setYearTill(),CVFormData.setJobDescription(),
                CVFormData.setAchievementDescription(), CVFormData.setAchievementYear(), CVFormData.setCertificationDescription(),
                CVFormData.setCertificationYear(), CVFormData.setCountLanguage(),CVFormData.setLanguageName(), CVFormData.setLinkedLink(),
                CVFormData.setGitHubLink(), CVFormData.setPortfolioLink(), CVFormData.setRecommendations());


    }


}
