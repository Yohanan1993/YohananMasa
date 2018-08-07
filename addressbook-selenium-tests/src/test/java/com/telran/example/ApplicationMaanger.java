package com.telran.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationMaanger extends GroupHelper{
    public WebDriver driver;

    public void strat() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        openAddressbook();
        login();
    }

    public void stop() {
        driver.quit();
    }

    public void openAddressbook() {
      driver.get("http://localhost/addressbook/");
    }

    public void login() {
      //Type username
      driver.findElement(By.name("user")).click();
      driver.findElement(By.name("user")).clear();
      driver.findElement(By.name("user")).sendKeys("admin");
      // Type password
      driver.findElement(By.name("pass")).click();
      driver.findElement(By.name("pass")).clear();
      driver.findElement(By.name("pass")).sendKeys("secret");
      // Login
      driver.findElement(By.xpath("//input[@value='Login']")).click();
    }


    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isContactPresent(){
        return isElementPresent(By.name("selected[]"));
    }

    public boolean isAlertPresent() {
      try {
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    public void confirmContactCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillContactForm(ContactData contactData) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());

        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(contactData.getLastName());

        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(contactData.getAddress());

        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys(contactData.getHomePhone());

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    protected void returnToHomePage() {
        driver.findElement(By.linkText("home")).click();
    }

    public void confirmAlert() {
//        String alertText = driver.switchTo().alert().getText();
//        System.out.println(alertText);
        driver.switchTo().alert().accept();
    }

    public void initContactDeletion() {
        driver.findElement(By.xpath("//*[@value='Delete']")).click();
    }

    public void selectContact() {
        driver.findElement(By.xpath("//*[@name='selected[]']")).click();
    }

    public void openHomePage() {
        driver.findElement(By.xpath("//*[@href='./']")).click();
    }

    protected int getContactsCount() {
        return driver.findElements(By.cssSelector("[name='selected[]']")).size();

    }

    public void selectContactByIndex(int index) {
        driver.findElements(By.xpath("//*[@name='selected[]']")).get(index).click();
    }

    public void clickOnUpdateButton() {
        driver.findElement(By.xpath("//input[@value='Update']")).click();
    }

    public void initContactModification() {
        driver.findElement(By.xpath("//img[@title='Edit']")).click();
    }

    public void createContact() {
        initContactCreation();
        fillContactForm(new ContactData()
                .withLastName("Vasily")
                .withFirstName("Ivanov")
                .withAddress("Tel-Aviv" )
                .withHomePhone("123456789")
                .withEmail("aa@dddd.com"));
        confirmContactCreation();
        returnToHomePage();
    }
}
