package com.telran.example.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationMaanger {
    GroupHelper groupHelper;
    ContactHelper contactHelper;
    SessionHelper sessionHelper;

    public WebDriver driver;

    public void strat() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.openAddressbook("http://localhost/addressbook/");
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(driver);
        contactHelper = new ContactHelper(driver);
    }

    public void stop() {
        driver.quit();
    }


    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

