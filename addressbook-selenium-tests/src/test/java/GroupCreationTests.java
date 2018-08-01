

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class GroupCreationTests extends TestBase{


  @Test
  public void testGroupCreation()  {
    openGroupsPage();
    int before = getGroupsCount();
    initGroupCreation();
    fillGroupForm("Yohanan", "header", "footer");
    submitGroupCreation();
    returnToGroupPage();
    int after = getGroupsCount();

    Assert.assertEquals(after, before+1);
  }

  @Test
  public void testGroupCreationEmptyFields()  {
    openGroupsPage();
    createGroup();
  }

  @Test
  public void testGroupLongName()  {
    openGroupsPage();
    initGroupCreation();
    fillGroupForm("Yohanaaaaaannnnnn", "header", "footer");
    submitGroupCreation();
    returnToGroupPage();
  }


}
