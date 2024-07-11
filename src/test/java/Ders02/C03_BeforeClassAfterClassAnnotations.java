package Ders02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClassAnnotations {
        /*
    BeforeClass - AfterClass
    ------------------------
    Before ve After Annotations'larından farklı olarak;
    BeforeClass ve AfterClass kullandığımızda testler tek tarayıcı sayfasında peş peşe çalışır.
    Sadece Before ve After kullanmış olsaydık testler tek tek açılıp kapanacaktı.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void test() {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com.tr");
    }

    @Test
    public void test1() {
        //Amazon sayfasına gidelim
        driver.get("https://www.facebook.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
