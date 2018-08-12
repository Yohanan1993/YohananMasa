package com.telran.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        int beforCreation = app.getContactHelper().getContactsCount();

        app.getContactHelper().createContact();

        int afterCreation = app.getContactHelper().getContactsCount();

        Assert.assertEquals(afterCreation, beforCreation + 1);
    }
}
