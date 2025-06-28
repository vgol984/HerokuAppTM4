import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;

public class TyposTest {
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
    public void test5() {
        driver.get("https://the-internet.herokuapp.com/typos");
        boolean cycleWithoutBreaks = true;
        String exceptedText = "Sometimes you'll see a typo, other times you won't.";

        for (int i = 0; i < 10; i++) {
            String actualText = driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]")).getText();
            if (actualText.equals(exceptedText)){
                driver.navigate().refresh();
                continue;
            }else{
                cycleWithoutBreaks = false;
                break;
            }
        }
        softAssert.assertTrue(cycleWithoutBreaks);
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
