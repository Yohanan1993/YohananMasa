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
        int before = getContactsCount();
        selectContact();
        initContactDeletion();
        confirmAlert();
        int after = getContactsCount();
        System.out.println("before: "+ before + " " + "after: " + after);
        Assert.assertEquals(after, before -1);
    }

    @Test
    public void deletionContactLastInTheList() {
        int before = getContactsCount();

        if(!isContactPresent()){
            createContact();
        }

        selectContactByIndex(before -1);
        initContactDeletion();
        confirmAlert();
        int after = getContactsCount();
        System.out.println("before: "+ before + " " + "after: " + after);
        Assert.assertEquals(after, before -1);
    }
    
}
