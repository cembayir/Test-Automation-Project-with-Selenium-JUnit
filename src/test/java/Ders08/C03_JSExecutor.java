package Ders08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_JSExecutor extends TestBaseBeforeAfter {

    /*
    TASK
    ----
    a.Amazon sayfasına gidelim.
    b.Aşağıdaki carrers butonunu görene kadar JS ile scroll yapalım.
    c.Carrers butonunu JS ile click yapalım.
     */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();
        WebElement kariyerButonu = driver.findElement(By.xpath("//*[text()='Kariyer']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", kariyerButonu);
        js.executeScript("arguments[0].click();", kariyerButonu);
    }
}