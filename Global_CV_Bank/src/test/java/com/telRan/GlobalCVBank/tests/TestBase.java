package com.telRan.GlobalCVBank.tests;

import com.telRan.GlobalCVBank.manager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase{

public ApplicationManager app = new ApplicationManager();
    @BeforeClass
    public void setUp() {

        app.start();
    }

    @AfterClass
    public void tearDown() {

       app.stop();
    }





}