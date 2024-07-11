package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_CssLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        -cssSelector sadece id ve class attributeleri için kullanılabilir.
        -id için başına # işareti konur.
        -class için başına . işareti konur.
         */

        //"https://the-internet.herokuapp.com/add_remove_elements/" adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basınız
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElement.click();

        //Delete butonunun görünüz olduğunu test ediniz
        WebElement deleteButton = driver.findElement(By.cssSelector(".added-manually"));
        if (deleteButton.isDisplayed()) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        //Delete butonuna basınız
        Thread.sleep(1000);
        deleteButton.click();

        //"Add/Remove Elements" yazısının görünüz olduğunu test ediniz
        if (driver.findElement(By.xpath("//*[text()='Add/Remove Elements']")).isDisplayed()) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        //Browser'ı kapatınız
        driver.close();
    }
}
