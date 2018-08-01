import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{
    @Test
    public void testGroupDeletion(){
        openGroupsPage();
        int beforeDeletion = getGroupsCount();
        selectGroup();
        initGroupDeletion();
        returnToGroupPage();
        int afterDeletion = getGroupsCount();

        Assert.assertEquals(afterDeletion, beforeDeletion -1);
    }

    @Test
    public void testGroupDeletionLastInTheList(){
        openGroupsPage();

        if(!isGroupPresent()){
            createGroup();
        }

        int beforeDeletion = getGroupsCount();
        int indexOfTheLastGroup = beforeDeletion -1;
        selectGroupByIndex(indexOfTheLastGroup);
        initGroupDeletion();
        returnToGroupPage();
        int afterDeletion = getGroupsCount();

        Assert.assertEquals(afterDeletion, beforeDeletion -1);

    }

}
