import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;

public class DropdownTest {
    WebDriver driver;
    SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        softAssert = new SoftAssert();

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");

        driver = new ChromeDriver(options);
    }

    @Test
    public void test3() {

        int exceptedCount = 3;

        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.id("dropdown"));
        Select select = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> elements = driver.findElements(By.tagName("option"));
        softAssert.assertEquals(elements.size(), exceptedCount);
        select.selectByValue("1");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/select/option[2]")).getText(), "Option 1");
        select.selectByValue("2");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/select/option[3]")).getText(), "Option 2");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
