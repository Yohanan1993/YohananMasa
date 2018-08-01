import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{
    @Test
    public void testContactModification(){

        if(!isContactPresent()){
            createContact();
        }
      int beforeModification = getContactsCount();

      selectContact();
      initContactModification();
      fillContactForm("ModyedName", "", "",
              "", "");
      clickOnUpdateButton();

      int afterModification = getContactsCount();

        Assert.assertEquals(afterModification, beforeModification);
    }

}
