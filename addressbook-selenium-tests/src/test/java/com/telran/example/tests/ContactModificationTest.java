package com.telran.example.tests;

import com.telran.example.model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification() {

        if (!app.getContactHelper().isContactPresent()) {
            app.getContactHelper().createContact();
        }
        int beforeModification = app.getContactHelper().getContactsCount();

        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(
                new ContactData()
                        .withFirstName("ModyedName")
                        .withLastName("")
                        .withAddress("")
                        .withHomePhone("")
                        .withEmail(""), By.name("address"));
        app.getContactHelper().clickOnUpdateButton();

        int afterModification = app.getContactHelper().getContactsCount();

        Assert.assertEquals(afterModification, beforeModification);
    }

}
