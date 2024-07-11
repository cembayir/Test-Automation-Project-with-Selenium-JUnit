package Ders08;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenshot extends TestBaseBeforeAfter {

    /*
    TASK
    ----
    a.BestBuy sayfasına gidelim ve tüm sayfanın resmini alalım.
     */

    @Test
    public void Test() throws IOException {
        driver.get("https://bestbuy.com");

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tumSayfa = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfa,new File("target/ekrangoruntuleri/Allpage " + tarih + " .jpeg"));
    }
}
