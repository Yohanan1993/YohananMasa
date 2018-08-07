package com.telran.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{
    @Test
    public void testGroupDeletion(){
        app.openGroupsPage();
        int beforeDeletion = app.getGroupsCount();
        app.selectGroup();
        app.initGroupDeletion();
        app.returnToGroupPage();
        int afterDeletion = app.getGroupsCount();

        Assert.assertEquals(afterDeletion, beforeDeletion -1);
    }

    @Test
    public void testGroupDeletionLastInTheList(){
        app.openGroupsPage();

        if(!app.isGroupPresent()){
            app.createGroup();
        }

        int beforeDeletion = app.getGroupsCount();
        int indexOfTheLastGroup = beforeDeletion -1;
        app.selectGroupByIndex(indexOfTheLastGroup);
        app.initGroupDeletion();
        app.returnToGroupPage();
        int afterDeletion = app.getGroupsCount();

        Assert.assertEquals(afterDeletion, beforeDeletion -1);

    }

}
