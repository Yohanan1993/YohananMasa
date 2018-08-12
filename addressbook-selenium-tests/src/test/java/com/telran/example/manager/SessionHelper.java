package com.telran.example.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void openAddressbook(String url) {
        driver.get(url);
    }

    public void login(String userName, String password) {
        //Type username
        type(By.name("user"), userName);

        // Type password
        type(By.name("pass"), password);

        // Login
        click(By.xpath("//input[@value='Login']"));
    }

}
