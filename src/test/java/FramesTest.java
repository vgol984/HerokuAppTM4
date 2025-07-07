import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest{
    @Test
    public void testInsideFrameTest(){

        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement frame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frame);
        softAssert.assertEquals(driver.findElement(By.tagName("p")).getText(), "Your content goes here.");
        driver.switchTo().parentFrame();
        softAssert.assertAll();
    }
}
