package com.telran.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {
    @Test
    public void testGroupDeletion() {
        app.getGroupHelper().openGroupsPage();
        int beforeDeletion = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupDeletion();
        app.getGroupHelper().returnToGroupPage();
        int afterDeletion = app.getGroupHelper().getGroupsCount();

        Assert.assertEquals(afterDeletion, beforeDeletion - 1);
    }

    @Test
    public void testGroupDeletionLastInTheList() {
        app.getGroupHelper().openGroupsPage();

        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup();
        }

        int beforeDeletion = app.getGroupHelper().getGroupsCount();
        int indexOfTheLastGroup = beforeDeletion - 1;
        app.getGroupHelper().selectGroupByIndex(indexOfTheLastGroup);
        app.getGroupHelper().initGroupDeletion();
        app.getGroupHelper().returnToGroupPage();
        int afterDeletion = app.getGroupHelper().getGroupsCount();

        Assert.assertEquals(afterDeletion, beforeDeletion - 1);

    }

}
