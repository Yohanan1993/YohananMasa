package com.telran.example;

import org.testng.Assert;
import org.testng.annotations.*;

public class GroupCreationTests extends TestBase{


  @Test
  public void testGroupCreation()  {
    app.openGroupsPage();
    int before = app.getGroupsCount();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData()
            .withName("Yohanan")
            .withHeader("header")
            .withFooter("footer"));
    app.submitGroupCreation();
    app.returnToGroupPage();
    int after = app.getGroupsCount();

    Assert.assertEquals(after, before+1);
  }

  @Test
  public void testGroupCreationEmptyFields()  {
    app.openGroupsPage();
    app.createGroup();
  }

  @Test
  public void testGroupLongName()  {
    app.openGroupsPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData()
            .withHeader("header")
            .withName("Yohanaaaaaannnnnn")
            .withFooter("footer"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
