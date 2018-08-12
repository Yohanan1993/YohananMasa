package com.telran.example.tests;

import com.telran.example.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getGroupHelper().openGroupsPage();
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withName("Yohanan")
                .withHeader("header")
                .withFooter("footer"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupsCount();

        Assert.assertEquals(after, before + 1);
    }

    @Test
    public void testGroupCreationEmptyFields() {
        app.getGroupHelper().openGroupsPage();
        app.getGroupHelper().createGroup();
    }

    @Test
    public void testGroupLongName() {
        app.getGroupHelper().openGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData()
                .withHeader("header")
                .withName("Yohanaaaaaannnnnn")
                .withFooter("footer"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

}
