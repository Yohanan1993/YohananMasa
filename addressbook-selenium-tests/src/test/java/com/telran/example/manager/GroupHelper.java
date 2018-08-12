package com.telran.example.manager;

import com.telran.example.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void openGroupsPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    public void fillGroupForm(GroupData groupData) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(groupData.getName());

        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());

        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void submitGroupModification() {
        driver.findElement(By.name("update")).click();
    }

    public void initGroupModification() {
        driver.findElement(By.name("edit")).click();
    }

    public void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void initGroupDeletion() {
        driver.findElement(By.name("delete")).click();
    }

    public int getGroupsCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void createGroup() {
        initGroupCreation();
        fillGroupForm(new GroupData().withName("").withHeader("").withFooter(""));
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }


    public void selectGroupByIndex(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }
}
