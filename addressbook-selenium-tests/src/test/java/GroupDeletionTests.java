import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{
    @Test
    public void testGroupDeletion(){
        openGroupsPage();
        selectGroup();
        initGroupDeletion();
        returnToGroupPage();
    }

}
