package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_Practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Facebook sayfasına gidin ve sayfa başlığının "facebook" olduğunu doğrulayın
        //Sayfa başlığı doğru değilse başlığı yazdırın
        driver.get("https://www.facebook.com");
        if (driver.getTitle().contains("facebook")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("Actual Title : " + driver.getTitle());
        }
        //Sayfa URL'inin "facebook" kelimesini içerdiğini doğrulayın, içermiyorsa "acturalUrl" değerinizi yazdırın
        if (driver.getCurrentUrl().contains("facebook")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("Actual URL : " + driver.getCurrentUrl());
        }
        //"https://www.walmart.com/" sayfasına gidin
        driver.navigate().to("https://www.walmart.com/");
        //Sayfa başlığının "walmart.com" içerdiğini doğrulayın
        if (driver.getTitle().contains("Walmart.com")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("Actual Title : " + driver.getTitle());
        }
        //Tekrar facebook sayfasına gidin
        driver.navigate().back();
        //Sayfayı yenileyin
        Thread.sleep(1000);
        driver.navigate().refresh();
        //Sayfayı maximize yapın
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        //Sayfayı kapatın
        driver.close();
    }
}
