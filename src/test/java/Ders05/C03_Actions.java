package Ders05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Actions extends TestBaseBeforeAfter {
    /*
    TASK
    ----
    a.https://www.amazon.com.tr adresine gidelim.
    b.Hesaplar menüsünden liste oluşturun linkine tıklayalım.
    c.Arama kutusuna Actions Metodlarını kullanarak "Iphone 15 Plus" yazdıralım ve Enter'a basarak arama yaptıralım.
    d.Aramanın gerçekleştiğini test edelim
    */

    @Test
    public void actionsTest() throws InterruptedException {
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();
        WebElement hesaplatButon = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        WebElement listeOlustur = driver.findElement(By.xpath("(//*[@class='nav-text'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hesaplatButon).click(listeOlustur).perform();

        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        actions.click(searchBox).keyDown(Keys.SHIFT).sendKeys("i").keyUp(Keys.SHIFT).sendKeys("phone").sendKeys(" ").sendKeys("15").sendKeys(" ")
                .keyDown(Keys.SHIFT).sendKeys("p").keyUp(Keys.SHIFT).sendKeys("lus").sendKeys(Keys.ENTER).perform();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Iphone 15 Plus";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}