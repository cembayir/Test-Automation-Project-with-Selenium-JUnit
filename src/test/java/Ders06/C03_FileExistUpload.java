package Ders06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_FileExistUpload extends TestBaseBeforeAfter {
    /*
    TASK
    ----
    a.https://the-internet.herokuapp.com/upload adresine gidelim.
    b.Dosya Seç butonuna basalım.
    c.Yüklemek istediğimiz dosyayı seçelim.
    d.Upload butonuna basalım.
    e."File Uploaded!" textinin görüntülendiğini test edelim.
    */
    @Test
    public void Test() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='file-upload']"));
        String yuklenecekDosya = "C:\\Users\\Cem\\Desktop\\test-metin.txt";
        dosyaSec.sendKeys(yuklenecekDosya);
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
