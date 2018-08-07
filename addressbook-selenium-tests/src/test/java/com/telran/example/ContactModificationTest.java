package com.telran.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{
    @Test
    public void testContactModification(){

        if(!app.isContactPresent()){
            app.createContact();
        }
      int beforeModification = app.getContactsCount();

      app.selectContact();
      app.initContactModification();
      app.fillContactForm(
              new ContactData()
                      .withFirstName("ModyedName")
                      .withLastName("")
                      .withAddress("")
                      .withHomePhone("")
                      .withEmail(""));
      app.clickOnUpdateButton();

      int afterModification = app.getContactsCount();

        Assert.assertEquals(afterModification, beforeModification);
    }

}
