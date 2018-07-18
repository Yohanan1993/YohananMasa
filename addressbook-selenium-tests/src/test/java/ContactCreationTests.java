import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation(){

        initContactCreation();
        fillContactForm("Vasily", "Ivanov", "Tel-Aviv", "123456789", "aa@dddd.com");
        confirmContactCreation();
        returnToHomePage();
    }


}
