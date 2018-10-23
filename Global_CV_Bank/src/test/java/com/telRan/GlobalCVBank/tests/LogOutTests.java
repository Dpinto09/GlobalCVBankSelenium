package com.telRan.GlobalCVBank.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        if(!isLoggedIn()){

            login();
        }
    }
    @Test
    public void testLogOut(){

        signOut();
    }

}
