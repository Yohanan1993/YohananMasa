import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification(){
        openGroupsPage();

        if(!isGroupPresent()){
            createGroup();
        }

        int beforeModification = getGroupsCount();

        selectGroup();
        initGroupModification();
        fillGroupForm("ModifyedName", "YV", "");
        submitGroupModification();
        returnToGroupPage();

        int afterModification = getGroupsCount();

        Assert.assertEquals(beforeModification, afterModification);
    }
}
