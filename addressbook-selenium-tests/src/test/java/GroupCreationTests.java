

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class GroupCreationTests extends TestBase{


  @Test
  public void testGroupCreation()  {
    openGroupsPage();
    int before= driver.findElements(By.name("selected[]")).size();
    initGroupCreation();
    fillGroupForm("Yohanan", "header", "footer");
    submitGroupCreation();
    returnToGroupPage();
    int after = driver.findElements(By.name("selected[]")).size();

    Assert.assertEquals(after, before+1);
  }

  @Test
  public void testGroupCreationEmptyFields()  {
    openGroupsPage();
    initGroupCreation();
    fillGroupForm("", "", "");
    submitGroupCreation();
    returnToGroupPage();
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
