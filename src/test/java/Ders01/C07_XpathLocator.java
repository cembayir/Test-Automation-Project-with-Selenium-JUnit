package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_XpathLocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //"https://the-internet.herokuapp.com/add_remove_elements/" adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basınız
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElement.click();

        //Delete butonunun görünüz olduğunu test ediniz
        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
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
