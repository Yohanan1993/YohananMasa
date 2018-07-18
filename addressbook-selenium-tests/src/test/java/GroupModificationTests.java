import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification(){
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm("ModifyedName", "YV", "");
        submitGroupModification();
        returnToGroupPage();
    }

}
