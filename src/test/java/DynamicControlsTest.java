import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControlsTest extends BaseTest{

    @Test
    public void inputEnabledTest(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button")).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("checkbox"))));
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's gone!"));
        WebElement input = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/input"));
        softAssert.assertFalse(input.isEnabled());
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button")).click();
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        softAssert.assertTrue(input.isEnabled());
        softAssert.assertAll();

    }

}
