import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;

public class CheckboxesTest {
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
    public void test2() {

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        softAssert.assertFalse(driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).isSelected());
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).click();
        softAssert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).isSelected());
        softAssert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).isSelected());
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).click();
        softAssert.assertFalse(driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).isSelected());
    }

   @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
