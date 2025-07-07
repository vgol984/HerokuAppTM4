import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileUploadTest extends BaseTest{

    @Test
    public void uploadTest(){
        driver.get("https://the-internet.herokuapp.com/upload");
        File file = new File("src/test/resources/test_image.jpg");
        driver.findElement(By.cssSelector("[type=file]")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        softAssert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "test_image.jpg");
        softAssert.assertAll();
    }

}
