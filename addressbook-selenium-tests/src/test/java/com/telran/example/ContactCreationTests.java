package com.telran.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation(){

        int beforCreation = app.getContactsCount();

        app.createContact();

        int afterCreation = app.getContactsCount();

        Assert.assertEquals(beforCreation, afterCreation +1);
    }


}
