import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      openAddressbook();
      login();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
      driver.quit();
    }

    //
    public void returnToGroupPage() {
      driver.findElement(By.linkText("group page")).click();
    }

    public void submitGroupCreation() {
      driver.findElement(By.name("submit")).click();
    }

    public void openGroupsPage() {
      driver.findElement(By.linkText("groups")).click();
    }

    public void initGroupCreation() {
      driver.findElement(By.name("new")).click();
    }

    public void fillGroupForm(String name, String header, String footer) {
      driver.findElement(By.name("group_name")).click();
      driver.findElement(By.name("group_name")).clear();
      driver.findElement(By.name("group_name")).sendKeys(name);

      driver.findElement(By.name("group_header")).click();
      driver.findElement(By.name("group_header")).clear();
      driver.findElement(By.name("group_header")).sendKeys(header);

      driver.findElement(By.name("group_footer")).click();
      driver.findElement(By.name("group_footer")).clear();
      driver.findElement(By.name("group_footer")).sendKeys(footer);
    }

    public void openAddressbook() {
      driver.get("http://localhost/addressbook/");
    }

    public void login() {
      //Type username
      driver.findElement(By.name("user")).click();
      driver.findElement(By.name("user")).clear();
      driver.findElement(By.name("user")).sendKeys("admin");
      // Type password
      driver.findElement(By.name("pass")).click();
      driver.findElement(By.name("pass")).clear();
      driver.findElement(By.name("pass")).sendKeys("secret");
      // Login
      driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    private boolean isElementPresent(By by) {
      try {
        driver.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    private boolean isAlertPresent() {
      try {
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    public void submitGroupModification() {
        driver.findElement(By.name("update")).click();
    }

    public void initGroupModification() {
        driver.findElement(By.name("edit")).click();
    }

    public void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void initGroupDeletion() {
        driver.findElement(By.name("delete")).click();
    }

    public void confirmContactCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void fillContactForm(String firstName, String lastName, String address, String homePhone, String email) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(firstName);

        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(lastName);

        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(address);

        driver.findElement(By.name("home")).click();
        driver.findElement(By.name("home")).clear();
        driver.findElement(By.name("home")).sendKeys(homePhone);

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    protected void returnToHomePage() {
        driver.findElement(By.linkText("home")).click();
    }
}
