package com.telran.example.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.getContactHelper().openHomePage();
    }

    @Test
    public void deletionContactTest() {

        if (!app.getContactHelper().isContactPresent()) {
            app.getContactHelper().createContact();
        }

        int before = app.getContactHelper().getContactsCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactDeletion();
        app.getContactHelper().confirmAlert();
        int after = app.getContactHelper().getContactsCount();
        System.out.println("before: " + before + " " + "after: " + after);
        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void deletionContactLastInTheList() {

        if (!app.getContactHelper().isContactPresent()) {
            app.getContactHelper().createContact();
        }

        int before = app.getContactHelper().getContactsCount();
        app.getContactHelper().selectContactByIndex(before - 1);
        app.getContactHelper().initContactDeletion();
        app.getContactHelper().confirmAlert();
        int after = app.getContactHelper().getContactsCount();
        System.out.println("before: " + before + " " + "after: " + after);
        Assert.assertEquals(after, before - 1);
    }

}
