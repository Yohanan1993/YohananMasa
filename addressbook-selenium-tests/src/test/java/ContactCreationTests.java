import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation(){

        int beforCreation = getContactsCount();

        createContact();

        int afterCreation = getContactsCount();

        Assert.assertEquals(beforCreation, afterCreation +1);
    }


}
