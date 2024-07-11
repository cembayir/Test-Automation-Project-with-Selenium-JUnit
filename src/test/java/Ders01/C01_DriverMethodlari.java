package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodlari {
    public static void main(String[] args) {
        //ChromeDriver'ı setup ediniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //"www.amazon.com.tr" adresine gidiniz
        driver.get("https://www.amazon.com.tr");
        //Sayfayı maximum boyuta getiriniz
        driver.manage().window().maximize();
        //Sayfanın başlığını yazdırınız
        System.out.println("Sayfa başlığı : " + driver.getTitle());
        //Sayfanın URL adresini yazdırınız
        System.out.println("Sayfanın URL Adresi : " + driver.getCurrentUrl());
        //Sayfanın kaynak kodlarını yazdırınız
        System.out.println("Sayfanın Kaynak Kodu : " + driver.getPageSource());
        //Kaynak kodların içinde "Gateway" kelimesinin olduğunu test ediniz
        String actualData = driver.getPageSource();
        String expectedData = "Gateway";
        if (actualData.contains(expectedData)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        //Sayfanın window handle kodunu yazdırınız
        System.out.println("Sayfanın Windows Handle Kodu : " + driver.getWindowHandle());
        //Sayfayı kapatınız
        driver.close();
    }
}
