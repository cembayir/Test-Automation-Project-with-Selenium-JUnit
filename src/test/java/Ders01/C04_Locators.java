package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_Locators {
    public static void main(String[] args) throws InterruptedException {
        //ChromeDriver'ı setup ediniz
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //"www.amazon.com.tr" adresine gidiniz
        driver.get("https://www.amazon.com.tr");
        //Amazonda notebook aratınız
        WebElement cerezler = driver.findElement(By.id("sp-cc-accept"));
        cerezler.click();
        Thread.sleep(2000);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("notebook", Keys.ENTER);
        //Amazon sayfasındaki tagların "a" olanlarının sayısını yazdırınız
        List<WebElement> tag = driver.findElements(By.tagName("a"));
        System.out.println("Tag'ı a olanların sayısı : " + tag.size());

        List<WebElement> label = driver.findElements(By.tagName("label"));
        System.out.println("Tag'ı label olanların sayısı : " + label.size());
        //Sayfayı kapatınız
        driver.close();
    }
}
