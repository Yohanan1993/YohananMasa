import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        openHomePage();

    }
    @Test
    public void deletionContactTest() {
        int before = getContactCount();
        selectContact();
        initContactDeletion();
        confirmAlert();
        int after = getContactCount();
        System.out.println("before: "+ before + " " + "after: " + after);
        Assert.assertEquals(after, before -1);
    }

    private int getContactCount() {
        return driver.findElements(By.cssSelector("[name='selected[]']")).size();

    }
}
