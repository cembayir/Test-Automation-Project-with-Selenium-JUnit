package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {
        //ChromeDriver'ı setup ediniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //"www.amazon.com.tr" adresine gidiniz
        driver.navigate().to("https://www.amazon.com.tr");
        //Google anasayfasına gidiniz
        driver.navigate().to("https://www.google.com");
        //Tekrar amazon sayfasına gidiniz
        Thread.sleep(1000);
        driver.navigate().back();
        //Tekrar google sayfasına gidiniz
        Thread.sleep(1000);
        driver.navigate().forward();
        //Sayfayı yenileyiniz
        Thread.sleep(1000);
        driver.navigate().refresh();
        //Sayfayı kapatınız
        driver.quit();
    }
}
