package Ders02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfterAnnotations {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Test() {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com.tr");
    }

    @Test
    public void Test1() {
        //Facebook sayfasına gidelim
        driver.get("https://www.facebook.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}