import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class ContextMenuTest extends BaseTest{

    @Test
    public void rightClickTest(){

        Actions actions = new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        actions.contextClick(hotSpot).perform();
        Alert alert = driver.switchTo().alert();
        softAssert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
        softAssert.assertAll();

    }

}
