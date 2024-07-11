package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManageMethodlari {
    public static void main(String[] args) throws InterruptedException {
        //ChromeDriver'ı setup ediniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //"www.amazon.com.tr" adresine gidiniz
        driver.get("https://www.amazon.com.tr");
        //Sayfanın konumunu ve boyutlarını yazdırınız
        System.out.println("Sayfanın konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfanın boyutu : " + driver.manage().window().getSize());
        //Sayfayı simge durumuna getiriniz
        driver.manage().window().minimize();
        //Simge durumunda 2 saniye bekleyip sayfayı maximize ediniz
        Thread.sleep(2000);
        driver.manage().window().maximize();
        //Sayfayı fullscreen yapınız
        Thread.sleep(1000);
        driver.manage().window().fullscreen();
        //Sayfanın konumunu ve boyutlarını fullscreen durumundayken yazdırınız
        System.out.println("Sayfanın fullscreen konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfanın fullscreen boyutu : " + driver.manage().window().getSize());
        //Sayfanın konumunu ve boyutlarını istediğiniz şekilde ayarlayınız
        driver.manage().window().setPosition(new Point(20, 20));
        driver.manage().window().setSize(new Dimension(800, 400));
        //Sayfanın istenilen konum ve boyutlarda ayarlandığını test ediniz
        System.out.println("Sayfanın istenilen konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfanın istenilen boyutu : " + driver.manage().window().getSize());
        //Sayfayı kapatınız
        driver.close();
    }
}
