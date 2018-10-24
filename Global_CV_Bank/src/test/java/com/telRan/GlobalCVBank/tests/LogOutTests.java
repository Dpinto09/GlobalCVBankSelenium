package com.telRan.GlobalCVBank.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){

        if(!app.getLoginHelper().isLoggedIn()){

            app.getLoginHelper().login();
        }
    }
    @Test
    public void testLogOut(){

        app.getLogOutHelper().signOut();
    }

}
