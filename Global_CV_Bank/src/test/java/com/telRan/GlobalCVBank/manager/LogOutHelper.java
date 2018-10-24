package com.telRan.GlobalCVBank.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutHelper extends HelperBase {
    public LogOutHelper(WebDriver wd) {
        super(wd);
    }

    public void signOut() {
        click(By.xpath("//ul[@class='menu-btns']//button[@type='button'][contains(text(),'Sign Out')]"));
    }
}
