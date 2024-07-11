package Ders06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExistDownload extends TestBaseBeforeAfter {
    /*
    TASK
    ----
    a.https://the-internetherokuapp.com/download adresine gidelim.
    b.Dummy1.txt dosyasını indirelim.
    c.Ardından isExist() metodunda dosyanın başarıyla indirilip indirilmediğini test edelim.
    d.İndirildiğini konsolda gösterelim.
     */

    @Test
    public void fileExistTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[text()='Dummy1.txt']")).click();
        Thread.sleep(1500);
        String dummyPath = "C:/Users/Cem/Downloads/Dummy1.txt/";
        Assert.assertTrue(Files.exists(Paths.get(dummyPath)));
        System.out.println(Paths.get(dummyPath));
    }
}