package com.telran.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification(){
        app.openGroupsPage();

        if(!app.isGroupPresent()){
            app.createGroup();
        }

        int beforeModification = app.getGroupsCount();

        app.selectGroup();
        app.initGroupModification();
        app.fillGroupForm(new GroupData()
                .withName("ModifyedName")
                .withHeader("YV")
                .withFooter(""));
        app.submitGroupModification();
        app.returnToGroupPage();

        int afterModification = app.getGroupsCount();

        Assert.assertEquals(beforeModification, afterModification);
    }
}
