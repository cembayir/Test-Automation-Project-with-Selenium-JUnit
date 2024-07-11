package Ders08;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C02_GetScreenshotWebElement extends TestBaseBeforeAfter {

    /*
    TASK
    ----
    a.Amazon sayfasına gidelim.
    b.Iphone aratalım.
    c.Arama sonuç yazısının resmini alalım.
     */

    @Test
    public void test() throws InterruptedException, IOException {
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Iphone" + Keys.ENTER);

        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        File aramasonucuWE = aramaSonucu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(aramasonucuWE, new File("target/WEScreenshot/WESS" + tarih + ".jpeg"));
    }
}