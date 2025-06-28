import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class SortableDataTablesTest {
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
    public void test6() {
        driver.get("https://the-internet.herokuapp.com/tables");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/table[1]/tbody/tr[1]/td[1]")).getText(), "Smith");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/table[1]/tbody/tr[1]/td[2]")).getText(), "John");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/table[1]/tbody/tr[1]/td[3]")).getText(), "jsmith@gmail.com");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/table[1]/tbody/tr[1]/td[4]")).getText(), "$50.00");
        softAssert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/table[1]/tbody/tr[1]/td[5]")).getText(), "http://www.jsmith.com");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
