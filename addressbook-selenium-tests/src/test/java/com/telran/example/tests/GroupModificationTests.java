package com.telran.example.tests;

import com.telran.example.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getGroupHelper().openGroupsPage();

        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup();
        }

        int beforeModification = app.getGroupHelper().getGroupsCount();

        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName("ModifyedName")
                .withHeader("YV")
                .withFooter(""));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();

        int afterModification = app.getGroupHelper().getGroupsCount();

        Assert.assertEquals(beforeModification, afterModification);
    }
}
