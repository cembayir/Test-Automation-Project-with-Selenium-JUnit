package Ders03;

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

public class C01_Assertions {
    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /*
    TASK
    ----
    a.Amazon sayfasına gidelim.
    b.4 farklı test metodu oluşturalım.
    c.URL'in amazon içerdiğini test edelim.
    d.Title'ın facebook içermediğini test edelim.
    e.Sol üst köşede amazon logosunun göründüğünü test edelim.
    f.URL'in www.facebook.com olduğunu test edelim.
     */

    @Test
    public void test1() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "amazon";
        Assert.assertTrue(actualURL.contains(expectedURL));

    }

    @Test
    public void test2() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
        //Zaten içermediğini bildiğim ve testin durmasını istemediğim için burada assertFalse kullanıyorum.
    }

    @Test
    public void test3() {
        WebElement amazonLogo = driver.findElement(By.cssSelector("#nav-logo-sprites"));
        Assert.assertTrue(amazonLogo.isDisplayed());

    }

    @Test
    public void test4() {
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "www.facebook.com";
        Assert.assertFalse(actualURL.contains(expectedURL));
    }
}