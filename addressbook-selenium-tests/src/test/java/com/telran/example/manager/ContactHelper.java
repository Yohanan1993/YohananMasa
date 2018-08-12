package com.telran.example.manager;

import com.telran.example.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver) {
        super(driver);
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

    public void fillContactForm(ContactData contactData, By locator) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone() );
        type(By.name("email"), contactData.getEmail());
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
                .withEmail("aa@dddd.com"), By.name("address"));
        confirmContactCreation();
        returnToHomePage();
    }
}
