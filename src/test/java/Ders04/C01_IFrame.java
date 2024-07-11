package Ders04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_IFrame {
    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /*
    TASK
    ----
    a.https://the-internet.herokuapp.com/iframe adresine gidin.
    b.Bir metod oluşturun --> iframeTest.
    c."An IFrame containing..." textinin erişilebilir olduğunu test edin ve konsola yazdırın.
    d.TextBox'a "Merhaba Dünya!" yazın.
    e.TextBox'ın altında bulunan "Elemental Selenium" textinin görünür olduğunu doğrulayın ve konsola yazdırın.
    */

    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframeText = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeText.isDisplayed());
        System.out.println(iframeText.getText());

        WebElement iframeTextBox = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeTextBox);
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        Thread.sleep(1000);
        iframeTextBox.sendKeys("Merhaba Dünya!");

        //driver.switchTo().parentFrame(); // <-- Bir üst seviyedeki frame'e geçiş yapar.
        driver.switchTo().defaultContent(); // <-- En üst seviyedeki frame'e geçiş yapar.

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText());
    }
}