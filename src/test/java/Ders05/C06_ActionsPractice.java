package Ders05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C06_ActionsPractice extends TestBaseBeforeAfter {
    /*
    TASK
    ----
    a.https://www.facebook.com adresine gidelim.
    b."Yeni hesap oluştur" butonuna basalım.
    c.Ad,Soyad,Mail ve Şifre alanlarına değer girelim ve Kaydol'a basalım.
    */
    @Test
    public void actionsTest() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement kaydolButonu = driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        Actions actions = new Actions(driver);
        actions.click(kaydolButonu).perform();
        Thread.sleep(1000);
        actions.sendKeys("Cem").sendKeys(Keys.TAB).sendKeys("BBB").sendKeys(Keys.TAB).sendKeys("999999999").sendKeys(Keys.TAB).sendKeys("5asd1w8481")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("28").sendKeys(Keys.TAB).sendKeys("May").sendKeys(Keys.TAB).sendKeys("1997").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
    }
}