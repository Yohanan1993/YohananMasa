package com.telran.example;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        app.openHomePage();
    }

    @Test
    public void deletionContactTest() {

        if(!app.isContactPresent()){
            app.createContact();
        }

        int before = app.getContactsCount();
        app.selectContact();
        app.initContactDeletion();
        app.confirmAlert();
        int after = app.getContactsCount();
        System.out.println("before: "+ before + " " + "after: " + after);
        Assert.assertEquals(after, before -1);
    }

    @Test
    public void deletionContactLastInTheList() {

        if(!app.isContactPresent()){
            app.createContact();
        }

        int before = app.getContactsCount();
        app.selectContactByIndex(before -1);
        app.initContactDeletion();
        app.confirmAlert();
        int after = app.getContactsCount();
        System.out.println("before: "+ before + " " + "after: " + after);
        Assert.assertEquals(after, before -1);
    }

}
