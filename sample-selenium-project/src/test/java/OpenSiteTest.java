import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenSiteTest {
ChromeDriver driver;

@BeforeMethod
public void setUp(){
    driver = new ChromeDriver();
}

@Test
public void enterURL(){
    openSite("https://search.maven.org");
    clickOnSearchButton();
    typeQueryToSearchFild(By.id("query"), "testng");


}

    public void typeQueryToSearchFild(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public void clickOnSearchButton() {
        driver.findElement(By.id("queryButton")).click();
    }

    @AfterMethod
public void tearDown() throws InterruptedException {
    Thread.sleep(3000);
    driver.quit();
}

}
