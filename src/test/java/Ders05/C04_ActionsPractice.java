package Ders05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_ActionsPractice extends TestBaseBeforeAfter {
    /*
    TASK
    ----
    a.https://the-intern.herokuapp.com/context_menu sitesine gidelim.
    b.Çizgili alanın üzerine gidip sağ click yapalım.
    c.Alert'te çıkan yazının "You selected a context menu" olduğunu test edelim.
    d.Tamam diyerek alert'i kapatalım.
    e."Elemental Selenium" linkine tıklayalım.
    f.Açılan sayfada h1 tag'ında "Elemental Selenium" yazdığını test edelim.
     */

    @Test
    public void actionsTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement cizgiliAlan = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(cizgiliAlan).perform();

        String actualText = driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Assert.assertEquals(expectedText, actualText);
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='themedComponent_mlkZ themedComponent--light_NVdE']")).isDisplayed());
    }
}